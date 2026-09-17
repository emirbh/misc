package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.LegacyValuationTime;
import cdm.legaldocumentation.csa.validation.LegacyValuationTimeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.LegacyValuationTimeValidator;
import cdm.legaldocumentation.csa.validation.datarule.LegacyValuationTimeAdditionalLanguage;
import cdm.legaldocumentation.csa.validation.datarule.LegacyValuationTimeDayAndTime;
import cdm.legaldocumentation.csa.validation.exists.LegacyValuationTimeOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=LegacyValuationTime.class)
public class LegacyValuationTimeMeta implements RosettaMetaData<LegacyValuationTime> {

	@Override
	public List<Validator<? super LegacyValuationTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegacyValuationTime>create(LegacyValuationTimeAdditionalLanguage.class),
			factory.<LegacyValuationTime>create(LegacyValuationTimeDayAndTime.class)
		);
	}
	
	@Override
	public List<Function<? super LegacyValuationTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyValuationTime> validator(ValidatorFactory factory) {
		return factory.<LegacyValuationTime>create(LegacyValuationTimeValidator.class);
	}

	@Override
	public Validator<? super LegacyValuationTime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyValuationTime>create(LegacyValuationTimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyValuationTime> validator() {
		return new LegacyValuationTimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyValuationTime> typeFormatValidator() {
		return new LegacyValuationTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyValuationTime, Set<String>> onlyExistsValidator() {
		return new LegacyValuationTimeOnlyExistsValidator();
	}
}
