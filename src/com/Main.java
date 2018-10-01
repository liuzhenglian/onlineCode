package com;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static String separator = File.separator;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Date date = new Date();
    //存储记录
    static class Record implements Comparable {
        private long timeStamp;
        private String lng;
        private String lat;

        public Record(long timeStamp, String lng, String lat) {
            this.timeStamp = timeStamp;
            this.lng = lng;
            this.lat = lat;
        }

        @Override
        public int compareTo(Object o) {
            Record that = (Record)o;
            if(timeStamp == that.timeStamp)
                return 0;
            else if (timeStamp > that.timeStamp) {
                return 1;
            }else{
                return -1;
            }
        }

        @Override
        public String toString() {
            date.setTime(this.timeStamp);
            return sdf.format(date)  +","+lat+","+lng;
        }
    }

    //希尔排序
    private static void ShellSort(Comparable[] comparables) {
        int length = comparables.length;
        if (length == 0 || length == 1) {
            return;
        }

        int N = 1;
        int i,j,k;

        while (true) {
            if (3 * N + 1 < length) {
                N = 3 * N + 1;
            }else{
                break;
            }
        }

        while (N >= 1) {
            for (i = 0; i < N; i++) {
                for (j = i + N ; j < length; j += N) {
                    k = j;
                    Comparable tmp = comparables[k];
                    while (k > i && tmp.compareTo(comparables[k-N]) < 0){
                        comparables[k] = comparables[k - N];
                        k -= N;

                    }
                    comparables[k] = tmp;
                }
            }
            N = (N - 1) / 3;
        }
    }
    /**
     * 获取路径下的所有文件/文件夹
     * @param directoryPath 需要遍历的文件夹路径
     * @param isAddDirectory 是否将子文件夹的路径也添加到list集合中
     * @return
     */
    private static List<String> getAllFile(String directoryPath,boolean isAddDirectory) {
        List<String> list = new ArrayList<String>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return list;
        }
        File[] files = baseFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                /*if(isAddDirectory){
                    list.add(file.getAbsolutePath());
                }*/
                list.addAll(getAllFile(file.getAbsolutePath(),isAddDirectory));
            } else {
                list.add(file.getAbsolutePath());
            }
        }
        return list;
    }


    /*
     *@param dir,0000000_0,0000000_1.....数据存放目录
     *@param resPath 合并后结果文件路径
     */
    public static void transform(String dir,String resPath) throws IOException {
        List<String> files =
                getAllFile(dir, false);

        FileWriter result = new FileWriter(resPath);
        //统计总记录数
        int totalLine = 0;
        //在dir目录下创建一个tmp文件,将所有小文件合成为1个大文件并统计该文件的行数
        FileWriter tmp = new FileWriter(dir + separator + "tmp");
        int i;
        for (String file : files) {

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str = null;
            while ((str=br.readLine()) != null) {

                String[] splits = str.split(",");
                if (splits.length != 4) {
                    continue;
                }
                totalLine++;
                tmp.write(str+"\n");
            }
            fr.close();
            br.close();
        }
        tmp.close();

        //保存已经处理过的ID
        Set<String> processed = new HashSet<>();
        //一部分文件的键值对
        Map<String, List<Record>> map = new HashMap<>();
        //每次处理的记录数
        int batch = totalLine / 10 + 1;

        FileReader fileReader = new FileReader(new File(dir + separator + "tmp"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = null;
        i = 0;
        int previous = i;
        int count = 0;
        while ((s = bufferedReader.readLine()) != null) {

            //处理一条记录
            String []strings = s.split(",");

            if(processed.contains(strings[0])==false){
                if (map.containsKey(strings[0])) {
                    Record record =
                            new Record(Long.valueOf(strings[3]),strings[2], strings[1]);
                    List<Record> list = map.get(strings[0]);
                    list.add(record);

                }else{
                    Record record =
                            new Record(Long.valueOf(strings[3]),strings[2], strings[1]);
                    List<Record> list = new ArrayList<>();
                    list.add(record);
                    map.put(strings[0], list);
                }
            }

            //处理的记录数+1
            count++;
            i++;
            if (count == batch || i == totalLine) {

                count = 0;
                //搜索整个文件
                FileReader fr = new FileReader(new File(dir + separator + "tmp"));
                BufferedReader br = new BufferedReader(fr);
                String str = null;
                int tmpLine = 0;
                while ((str=br.readLine()) != null) {

                    if (tmpLine >= previous && tmpLine < i) {
                        tmpLine++;
                        continue;
                    }
                    String[] splits = str.split(",");
                    if (map.containsKey(splits[0])==true &&!processed.contains(splits[0])) {
                        List<Record> list = map.get(splits[0]);
                        Record record =
                                new Record(Long.valueOf(splits[3]),splits[2], splits[1]);
                        list.add(record);
                    }
                    tmpLine++;
                }
                //将Map写到文件,并将该部分ID添加到processed set
                for (Map.Entry<String, List<Record>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    List<Record> value = entry.getValue();
                    Record[] records = new Record[value.size()];
                    value.toArray(records);
                    //按照时间戳对同一个用户记录进行排序
                    ShellSort(records);
                    //写文件
                    String write = key;
                    for (Record record : records) {
                        write += ",";
                        write += record;
                    }
                    write += '\n';
                    result.write(write);
                    value.clear();
                    processed.add(key);
                }
                fr.close();
                br.close();
                map.clear();
                previous = i;
            }

        }
        result.close();
    }
    public static void main(String[] args) throws IOException {
        System.out.println("正在计算......");
        //参数一：原始文件存放目录，参数二：结果文件存放路径
        //该函数会读取目录下所有文件的内容。
        //因此，为了不产生混乱，确保原始文件目录不要有其余的文件，只留下原始数据。
        //结果文件最好不要放在原始文件目录下，否则多次运行时有问题。
        transform("/home/hjw/Desktop/file","/home/hjw/Desktop/result.txt");
        //System.out.println(files);
        System.out.println("计算结束......");
    }
}

