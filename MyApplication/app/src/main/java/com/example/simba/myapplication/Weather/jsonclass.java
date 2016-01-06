package com.example.simba.myapplication.Weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class jsonclass  {


	private String resultcode;
	private String reason;
	private result result;
	private int error_code;

	@Override
	public String toString() {
		return "jsonclass{" +
				"resultcode='" + resultcode + '\'' +
				", reason='" + reason + '\'' +
				", result=" + result.toString() +
				", error_code=" + error_code +
				'}';
	}

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public jsonclass.result getResult() {
		return result;
	}

	public void setResult(jsonclass.result result) {
		this.result = result;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}



	class result{
		private sk sk;
		private today today;
		private List<future> future;

		@Override
		public String toString() {
			return "result{" +
					"sk=" + sk +
					", today=" + today.toString() +
					", future=" + future.toString() +
					'}';
		}

		public jsonclass.result.sk getSk() {
			return sk;
		}

		public void setSk(jsonclass.result.sk sk) {
			this.sk = sk;
		}

		public jsonclass.result.today getToday() {
			return today;
		}

		public void setToday(jsonclass.result.today today) {
			this.today = today;
		}

		public List<jsonclass.result.future> getFuture() {
			return future;
		}

		public void setFuture(List<jsonclass.result.future> future) {
			this.future = future;
		}

		class sk{
			private String temp;
			private String wind_direction;
			private String wind_strength;
			private String humidity;
			private String time;

			@Override
			public String toString() {
				return "sk{" +
						"temp='" + temp + '\'' +
						", wind_direction='" + wind_direction + '\'' +
						", wind_strength='" + wind_strength + '\'' +
						", humidity='" + humidity + '\'' +
						", time='" + time + '\'' +
						'}';
			}

			public String getTemp() {
				return temp;
			}

			public void setTemp(String temp) {
				this.temp = temp;
			}

			public String getWind_direction() {
				return wind_direction;
			}

			public void setWind_direction(String wind_direction) {
				this.wind_direction = wind_direction;
			}

			public String getWind_strength() {
				return wind_strength;
			}

			public void setWind_strength(String wind_strength) {
				this.wind_strength = wind_strength;
			}

			public String getHumidity() {
				return humidity;
			}

			public void setHumidity(String humidity) {
				this.humidity = humidity;
			}

			public String getTime() {
				return time;
			}

			public void setTime(String time) {
				this.time = time;
			}
		}
		class today{
			private String temperature;
			private String weather;
			private weather_id weather_id;
			private String wind;
			private String week;
			private String city;
			private String date_y;
			private String dressing_index;
			private String dressing_advice;
			private String uv_index;
			private String confort_index;
			private String travel_index;
			private String exercise_index;
			private String drying_advice;

			@Override
			public String toString() {
				return "today{" +
						"temperature='" + temperature + '\'' +
						", weather='" + weather + '\'' +
						", weather_id=" + weather_id.toString() +
						", wind='" + wind + '\'' +
						", week='" + week + '\'' +
						", city='" + city + '\'' +
						", date_y='" + date_y + '\'' +
						", dressing_index='" + dressing_index + '\'' +
						", dressing_advice='" + dressing_advice + '\'' +
						", uv_index='" + uv_index + '\'' +
						", confort_index='" + confort_index + '\'' +
						", travel_index='" + travel_index + '\'' +
						", exercise_index='" + exercise_index + '\'' +
						", drying_advice='" + drying_advice + '\'' +
						'}';
			}

			public String getTemperature() {
				return temperature;
			}

			public void setTemperature(String temperature) {
				this.temperature = temperature;
			}

			public String getWeather() {
				return weather;
			}

			public void setWeather(String weather) {
				this.weather = weather;
			}

			public jsonclass.result.today.weather_id getWeather_id() {
				return weather_id;
			}

			public void setWeather_id(jsonclass.result.today.weather_id weather_id) {
				this.weather_id = weather_id;
			}

			public String getWind() {
				return wind;
			}

			public void setWind(String wind) {
				this.wind = wind;
			}

			public String getWeek() {
				return week;
			}

			public void setWeek(String week) {
				this.week = week;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getDate_y() {
				return date_y;
			}

			public void setDate_y(String date_y) {
				this.date_y = date_y;
			}

			public String getDressing_index() {
				return dressing_index;
			}

			public void setDressing_index(String dressing_index) {
				this.dressing_index = dressing_index;
			}

			public String getDressing_advice() {
				return dressing_advice;
			}

			public void setDressing_advice(String dressing_advice) {
				this.dressing_advice = dressing_advice;
			}

			public String getUv_index() {
				return uv_index;
			}

			public void setUv_index(String uv_index) {
				this.uv_index = uv_index;
			}

			public String getConfort_index() {
				return confort_index;
			}

			public void setConfort_index(String confort_index) {
				this.confort_index = confort_index;
			}

			public String getTravel_index() {
				return travel_index;
			}

			public void setTravel_index(String travel_index) {
				this.travel_index = travel_index;
			}

			public String getExercise_index() {
				return exercise_index;
			}

			public void setExercise_index(String exercise_index) {
				this.exercise_index = exercise_index;
			}

			public String getDrying_advice() {
				return drying_advice;
			}

			public void setDrying_advice(String drying_advice) {
				this.drying_advice = drying_advice;
			}

			class weather_id{
				private String fa;
				private String fb;

				@Override
				public String toString() {
					return "weather_id{" +
							"fa='" + fa + '\'' +
							", fb='" + fb + '\'' +
							'}';
				}

				public String getFa() {
					return fa;
				}

				public void setFa(String fa) {
					this.fa = fa;
				}

				public String getFb() {
					return fb;
				}

				public void setFb(String fb) {
					this.fb = fb;
				}
			}

		}

		class future{
			private String temperature;
			private String weather;
			private weather_id weather_id;
			private String wind;
			private String week;
			private String date;

			@Override
			public String toString() {
				return "future{" +
						"temperature='" + temperature + '\'' +
						", weather='" + weather + '\'' +
						", weather_id=" + weather_id.toString() +
						", wind='" + wind + '\'' +
						", week='" + week + '\'' +
						", date='" + date + '\'' +
						'}';
			}

			public String getTemperature() {
				return temperature;
			}

			public void setTemperature(String temperature) {
				this.temperature = temperature;
			}

			public String getWeather() {
				return weather;
			}

			public void setWeather(String weather) {
				this.weather = weather;
			}

			public jsonclass.result.future.weather_id getWeather_id() {
				return weather_id;
			}

			public void setWeather_id(jsonclass.result.future.weather_id weather_id) {
				this.weather_id = weather_id;
			}

			public String getWind() {
				return wind;
			}

			public void setWind(String wind) {
				this.wind = wind;
			}

			public String getWeek() {
				return week;
			}

			public void setWeek(String week) {
				this.week = week;
			}

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			class weather_id{

				private String fa;
				private String fb;

				@Override
				public String toString() {
					return "weather_id{" +
							"fa='" + fa + '\'' +
							", fb='" + fb + '\'' +
							'}';
				}

				public String getFa() {
					return fa;
				}

				public void setFa(String fa) {
					this.fa = fa;
				}

				public String getFb() {
					return fb;
				}

				public void setFb(String fb) {
					this.fb = fb;
				}
			}

		}
	}


	
}
