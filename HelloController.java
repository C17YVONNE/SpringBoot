package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Weather;
import com.example.demo.service.WeatherService;

@Controller
public class HelloController {

	@Autowired
	WeatherService weatherService;

	@GetMapping("/hello")
	public String hello(Model model) {
		// Hello World!の表示
		model.addAttribute("hello", "Hello World!");

		// 気象データの取得
		List<Weather> weatherDataList = weatherService.findAllWeatherData();
		model.addAttribute("weatherDataList", weatherDataList);

		List<Weather> weatherDataTokyo = weatherService.findWeatherDataListByName("東京");
		model.addAttribute("weatherDataTokyo", weatherDataTokyo);

		List<Weather> weatherDataNaha = weatherService.findWeatherDataListByName("那覇");
		model.addAttribute("weatherDataNaha", weatherDataNaha);

		return "hello";
	}
}
