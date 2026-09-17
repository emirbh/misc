package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityPrepayment;
import fpml.consolidated.loan.validation.FacilityPrepaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityPrepaymentValidator;
import fpml.consolidated.loan.validation.exists.FacilityPrepaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityPrepayment.class)
public class FacilityPrepaymentMeta implements RosettaMetaData<FacilityPrepayment> {

	@Override
	public List<Validator<? super FacilityPrepayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityPrepayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityPrepayment> validator(ValidatorFactory factory) {
		return factory.<FacilityPrepayment>create(FacilityPrepaymentValidator.class);
	}

	@Override
	public Validator<? super FacilityPrepayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityPrepayment>create(FacilityPrepaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityPrepayment> validator() {
		return new FacilityPrepaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityPrepayment> typeFormatValidator() {
		return new FacilityPrepaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityPrepayment, Set<String>> onlyExistsValidator() {
		return new FacilityPrepaymentOnlyExistsValidator();
	}
}
