package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.SettlementPeriodsReference;
import fpml.consolidated.com.validation.SettlementPeriodsReferenceTypeFormatValidator;
import fpml.consolidated.com.validation.SettlementPeriodsReferenceValidator;
import fpml.consolidated.com.validation.exists.SettlementPeriodsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementPeriodsReference.class)
public class SettlementPeriodsReferenceMeta implements RosettaMetaData<SettlementPeriodsReference> {

	@Override
	public List<Validator<? super SettlementPeriodsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPeriodsReference> validator(ValidatorFactory factory) {
		return factory.<SettlementPeriodsReference>create(SettlementPeriodsReferenceValidator.class);
	}

	@Override
	public Validator<? super SettlementPeriodsReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPeriodsReference>create(SettlementPeriodsReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriodsReference> validator() {
		return new SettlementPeriodsReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriodsReference> typeFormatValidator() {
		return new SettlementPeriodsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodsReference, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodsReferenceOnlyExistsValidator();
	}
}
