package test.demo.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LightSenorActivity extends AppCompatActivity {

    ProgressBar lightMeter;
    TextView tvMaxValue;
    TextView tvReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_senor);

        lightMeter = (ProgressBar) findViewById(R.id.lightmeter);
        tvMaxValue = (TextView) findViewById(R.id.max);
        tvReader = (TextView) findViewById(R.id.reading);

        // implement sensor manager
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        // check sensor available in devise. if available then get reading
        if (lightSensor == null) {
            Toast.makeText(getApplicationContext(), "No Sensor",
                    Toast.LENGTH_SHORT).show();
            // Toast.makeText(AndroidLightSensorActivity.this,
            // "No Light Sensor! quit-", Toast.LENGTH_LONG).show();
        } else {
            float max = lightSensor.getMaximumRange();
            lightMeter.setMax((int) max);
            tvMaxValue.setText("Max Reading: " + String.valueOf(max));

            sensorManager.registerListener(lightSensorEventListener,
                    lightSensor, SensorManager.SENSOR_DELAY_NORMAL);

        }
    }

    SensorEventListener lightSensorEventListener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        // get sensor update and reading
        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub
            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                float currentReading = event.values[0];
                lightMeter.setProgress((int) currentReading);
                tvReader.setText("Current Reading: "
                        + String.valueOf(currentReading) + " Lux");
            }
        }
    };
}
