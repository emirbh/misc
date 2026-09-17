package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SettlementPriceDefaultElection;
import fpml.consolidated.shared.validation.SettlementPriceDefaultElectionTypeFormatValidator;
import fpml.consolidated.shared.validation.SettlementPriceDefaultElectionValidator;
import fpml.consolidated.shared.validation.exists.SettlementPriceDefaultElectionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementPriceDefaultElection.class)
public class SettlementPriceDefaultElectionMeta implements RosettaMetaData<SettlementPriceDefaultElection> {

	@Override
	public List<Validator<? super SettlementPriceDefaultElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPriceDefaultElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPriceDefaultElection> validator(ValidatorFactory factory) {
		return factory.<SettlementPriceDefaultElection>create(SettlementPriceDefaultElectionValidator.class);
	}

	@Override
	public Validator<? super SettlementPriceDefaultElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPriceDefaultElection>create(SettlementPriceDefaultElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPriceDefaultElection> validator() {
		return new SettlementPriceDefaultElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPriceDefaultElection> typeFormatValidator() {
		return new SettlementPriceDefaultElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPriceDefaultElection, Set<String>> onlyExistsValidator() {
		return new SettlementPriceDefaultElectionOnlyExistsValidator();
	}
}
