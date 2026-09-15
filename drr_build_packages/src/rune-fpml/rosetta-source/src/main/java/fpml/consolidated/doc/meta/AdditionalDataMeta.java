package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.doc.validation.AdditionalDataTypeFormatValidator;
import fpml.consolidated.doc.validation.AdditionalDataValidator;
import fpml.consolidated.doc.validation.datarule.AdditionalDataChoice;
import fpml.consolidated.doc.validation.exists.AdditionalDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdditionalData.class)
public class AdditionalDataMeta implements RosettaMetaData<AdditionalData> {

	@Override
	public List<Validator<? super AdditionalData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdditionalData>create(AdditionalDataChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdditionalData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalData> validator(ValidatorFactory factory) {
		return factory.<AdditionalData>create(AdditionalDataValidator.class);
	}

	@Override
	public Validator<? super AdditionalData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalData>create(AdditionalDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalData> validator() {
		return new AdditionalDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalData> typeFormatValidator() {
		return new AdditionalDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalData, Set<String>> onlyExistsValidator() {
		return new AdditionalDataOnlyExistsValidator();
	}
}
