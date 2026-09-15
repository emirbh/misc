package fpml.consolidated.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.ValuationSetDetail;
import fpml.consolidated.valuation.validation.ValuationSetDetailTypeFormatValidator;
import fpml.consolidated.valuation.validation.ValuationSetDetailValidator;
import fpml.consolidated.valuation.validation.exists.ValuationSetDetailOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ValuationSetDetail.class)
public class ValuationSetDetailMeta implements RosettaMetaData<ValuationSetDetail> {

	@Override
	public List<Validator<? super ValuationSetDetail>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationSetDetail, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationSetDetail> validator(ValidatorFactory factory) {
		return factory.<ValuationSetDetail>create(ValuationSetDetailValidator.class);
	}

	@Override
	public Validator<? super ValuationSetDetail> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationSetDetail>create(ValuationSetDetailTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationSetDetail> validator() {
		return new ValuationSetDetailValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationSetDetail> typeFormatValidator() {
		return new ValuationSetDetailTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationSetDetail, Set<String>> onlyExistsValidator() {
		return new ValuationSetDetailOnlyExistsValidator();
	}
}
