package fpml.consolidated.eqd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eqd.EquityOptionTransactionSupplement;
import fpml.consolidated.eqd.validation.EquityOptionTransactionSupplementTypeFormatValidator;
import fpml.consolidated.eqd.validation.EquityOptionTransactionSupplementValidator;
import fpml.consolidated.eqd.validation.datarule.EquityOptionTransactionSupplementChoice0;
import fpml.consolidated.eqd.validation.datarule.EquityOptionTransactionSupplementChoice1;
import fpml.consolidated.eqd.validation.exists.EquityOptionTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityOptionTransactionSupplement.class)
public class EquityOptionTransactionSupplementMeta implements RosettaMetaData<EquityOptionTransactionSupplement> {

	@Override
	public List<Validator<? super EquityOptionTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EquityOptionTransactionSupplement>create(EquityOptionTransactionSupplementChoice0.class),
			factory.<EquityOptionTransactionSupplement>create(EquityOptionTransactionSupplementChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super EquityOptionTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityOptionTransactionSupplement> validator(ValidatorFactory factory) {
		return factory.<EquityOptionTransactionSupplement>create(EquityOptionTransactionSupplementValidator.class);
	}

	@Override
	public Validator<? super EquityOptionTransactionSupplement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityOptionTransactionSupplement>create(EquityOptionTransactionSupplementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityOptionTransactionSupplement> validator() {
		return new EquityOptionTransactionSupplementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityOptionTransactionSupplement> typeFormatValidator() {
		return new EquityOptionTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityOptionTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new EquityOptionTransactionSupplementOnlyExistsValidator();
	}
}
