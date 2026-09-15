package drr.standards.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iso.MicData;
import drr.standards.iso.validation.MicDataTypeFormatValidator;
import drr.standards.iso.validation.MicDataValidator;
import drr.standards.iso.validation.datarule.MicDataCardinalityVerification;
import drr.standards.iso.validation.datarule.MicDataMICIsNotXOFFOrXXXX;
import drr.standards.iso.validation.exists.MicDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=MicData.class)
public class MicDataMeta implements RosettaMetaData<MicData> {

	@Override
	public List<Validator<? super MicData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MicData>create(MicDataMICIsNotXOFFOrXXXX.class),
			factory.<MicData>create(MicDataCardinalityVerification.class)
		);
	}
	
	@Override
	public List<Function<? super MicData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MicData> validator(ValidatorFactory factory) {
		return factory.<MicData>create(MicDataValidator.class);
	}

	@Override
	public Validator<? super MicData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MicData>create(MicDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MicData> validator() {
		return new MicDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MicData> typeFormatValidator() {
		return new MicDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MicData, Set<String>> onlyExistsValidator() {
		return new MicDataOnlyExistsValidator();
	}
}
