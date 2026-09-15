package drr.enrichment.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.enrichment.upi.UpiData;
import drr.enrichment.upi.validation.UpiDataTypeFormatValidator;
import drr.enrichment.upi.validation.UpiDataValidator;
import drr.enrichment.upi.validation.datarule.UpiDataCardinalityVerification;
import drr.enrichment.upi.validation.exists.UpiDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=UpiData.class)
public class UpiDataMeta implements RosettaMetaData<UpiData> {

	@Override
	public List<Validator<? super UpiData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<UpiData>create(UpiDataCardinalityVerification.class)
		);
	}
	
	@Override
	public List<Function<? super UpiData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UpiData> validator(ValidatorFactory factory) {
		return factory.<UpiData>create(UpiDataValidator.class);
	}

	@Override
	public Validator<? super UpiData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UpiData>create(UpiDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UpiData> validator() {
		return new UpiDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UpiData> typeFormatValidator() {
		return new UpiDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UpiData, Set<String>> onlyExistsValidator() {
		return new UpiDataOnlyExistsValidator();
	}
}
