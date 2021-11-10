package ua.vehicle.registrations.data.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CsvVehicleRegistrationRecordDto {

    @SerializedName(value = "PERSON", alternate = {"person"})
    private String personType;
    @SerializedName(value = "OPER_CODE", alternate = {"oper_code"})
    private Long opCode;
    @SerializedName(value = "OPER_NAME", alternate = {"oper_name"})
    private String opName;
    @SerializedName(value = "D_REG", alternate = {"d_reg"})
    private String registrationDate;
    @SerializedName(value = "DEP_CODE", alternate = {"dep_code"})
    private Long depCode;
    @SerializedName(value = "DEP", alternate = {"dep"})
    private String depName;
    @SerializedName(value = "BRAND", alternate = {"brand"})
    private String brandName;
    @SerializedName(value = "MODEL", alternate = {"model"})
    private String modelName;
    @SerializedName(value = "MAKE_YEAR", alternate = {"make_year"})
    private Long makeYear;
    @SerializedName(value = "COLOR", alternate = {"color"})
    private String colorName;
    @SerializedName(value = "KIND", alternate = {"kind"})
    private String kindName;
    @SerializedName(value = "BODY", alternate = {"body"})
    private String bodyType;
    @SerializedName(value = "PURPOSE", alternate = {"purpose"})
    private String purposeName;
    @SerializedName(value = "REG_ADDR_KOATUU", alternate = {"reg_addr_koatuu"})
    private String personRegistrationAddress; // NULLABLE
    @SerializedName(value = "FUEL", alternate = {"fuel"})
    private String fuelType;// NULLABLE
    @SerializedName(value = "CAPACITY", alternate = {"capacity"})
    private Long engineCapacity;// NULLABLE
    @SerializedName(value = "OWN_WEIGHT", alternate = {"own_weight"})
    private Long ownWeight;// NULLABLE
    @SerializedName(value = "TOTAL_WEIGHT", alternate = {"total_weight"})
    private Long totalWeight;// NULLABLE
    @SerializedName(value = "N_REG_NEW", alternate = {"n_reg_new"})
    private String registrationNumber;// NULLABLE
    @SerializedName(value = "VIN", alternate = {"vin"})
    private String vinNumber;// NULLABLE
}
