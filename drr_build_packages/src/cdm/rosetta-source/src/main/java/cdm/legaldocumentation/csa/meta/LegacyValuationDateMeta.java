package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.LegacyValuationDate;
import cdm.legaldocumentation.csa.validation.LegacyValuationDateTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.LegacyValuationDateValidator;
import cdm.legaldocumentation.csa.validation.datarule.LegacyValuationDateAdditionalLanguage;
import cdm.legaldocumentation.csa.validation.datarule.LegacyValuationDateCalendarDay;
import cdm.legaldocumentation.csa.validation.exists.LegacyValuationDateOnlyExistsValidator;
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
@RosettaMeta(model=LegacyValuationDate.class)
public class LegacyValuationDateMeta implements RosettaMetaData<LegacyValuationDate> {

	@Override
	public List<Validator<? super LegacyValuationDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegacyValuationDate>create(LegacyValuationDateCalendarDay.class),
			factory.<LegacyValuationDate>create(LegacyValuationDateAdditionalLanguage.class)
		);
	}
	
	@Override
	public List<Function<? super LegacyValuationDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyValuationDate> validator(ValidatorFactory factory) {
		return factory.<LegacyValuationDate>create(LegacyValuationDateValidator.class);
	}

	@Override
	public Validator<? super LegacyValuationDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyValuationDate>create(LegacyValuationDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyValuationDate> validator() {
		return new LegacyValuationDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyValuationDate> typeFormatValidator() {
		return new LegacyValuationDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyValuationDate, Set<String>> onlyExistsValidator() {
		return new LegacyValuationDateOnlyExistsValidator();
	}
}
