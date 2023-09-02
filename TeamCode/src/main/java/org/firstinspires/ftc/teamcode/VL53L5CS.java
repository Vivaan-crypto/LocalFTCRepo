package org.firstinspires.ftc.teamcode.Teleop;
import static com.qualcomm.hardware.stmicroelectronics.VL53L0X.ADDRESS_I2C_DEFAULT;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchDevice;
import com.qualcomm.robotcore.hardware.configuration.I2cSensor;
import com.qualcomm.robotcore.hardware.configuration.annotations.I2cDeviceType;

@I2cSensor(name = "MCP9808 Temperature Sensor", description = "Temperature Sensor from Adafruit", xmlTag = "MCP9808")
@I2cDeviceType()
public class VL53L5CX extends I2cDeviceSynchDevice<I2cDeviceSynch>
{
    public enum Register
    {
        CONFIGURATION(0x01),
        T_LIMIT_UPPER(0x02),
        T_LIMIT_LOWER(0x03),
        T_LIMIT_CRITICAL(0x04),
        TEMPERATURE(0x05),
        MANUFACTURER_ID(0x06),
        DEVICE_ID_REVISION(0x07),
        RESOLUTION(0x08);

        public int bVal;

        Register(int bVal)
        {
            this.bVal = bVal;
        }
    }
    @Override
    protected synchronized boolean doInitialize() {
        return true;
    }

    @Override
    public Manufacturer getManufacturer() {
        return Manufacturer.STMicroelectronics;
    }

    @Override
    public String getDeviceName() {
        return "STM VL53L5CX ToF Sensor";
    }
    public VL53L5CX(I2cDeviceSynch deviceClient){
        super(deviceClient, true);

        this.deviceClient.setI2cAddress(ADDRESS_I2C_DEFAULT);


        super.registerArmingStateCallback(false);
        this.deviceClient.engage();

    }
}
