package drr.enrichment.lei.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.validation.LeiDataTypeFormatValidator;
import drr.enrichment.lei.validation.LeiDataValidator;
import drr.enrichment.lei.validation.datarule.LeiDataCardinalityVerification;
import drr.enrichment.lei.validation.exists.LeiDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=LeiData.class)
public class LeiDataMeta implements RosettaMetaData<LeiData> {

	@Override
	public List<Validator<? super LeiData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LeiData>create(LeiDataCardinalityVerification.class)
		);
	}
	
	@Override
	public List<Function<? super LeiData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LeiData> validator(ValidatorFactory factory) {
		return factory.<LeiData>create(LeiDataValidator.class);
	}

	@Override
	public Validator<? super LeiData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LeiData>create(LeiDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LeiData> validator() {
		return new LeiDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LeiData> typeFormatValidator() {
		return new LeiDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LeiData, Set<String>> onlyExistsValidator() {
		return new LeiDataOnlyExistsValidator();
	}
}
