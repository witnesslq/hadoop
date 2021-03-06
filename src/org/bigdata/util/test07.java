package org.bigdata.util;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapFile;
import org.apache.hadoop.io.Text;

public class test07 {
	public static void main(String[] args) throws IOException{
		Configuration config = HadoopConfig.getConfig();
		Path path = new Path("/map.dat");
		MapFile.Reader reader = new MapFile.Reader(path,config);
		IntWritable key = new IntWritable();
		Text value = new Text();
		while(reader.next(key,value)){
			System.out.println(key + "----->" + value);
		}
		reader.close();
	}
}
