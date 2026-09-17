package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.SettlementProvision;
import fpml.consolidated.ird.validation.SettlementProvisionTypeFormatValidator;
import fpml.consolidated.ird.validation.SettlementProvisionValidator;
import fpml.consolidated.ird.validation.exists.SettlementProvisionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementProvision.class)
public class SettlementProvisionMeta implements RosettaMetaData<SettlementProvision> {

	@Override
	public List<Validator<? super SettlementProvision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementProvision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementProvision> validator(ValidatorFactory factory) {
		return factory.<SettlementProvision>create(SettlementProvisionValidator.class);
	}

	@Override
	public Validator<? super SettlementProvision> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementProvision>create(SettlementProvisionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementProvision> validator() {
		return new SettlementProvisionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementProvision> typeFormatValidator() {
		return new SettlementProvisionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementProvision, Set<String>> onlyExistsValidator() {
		return new SettlementProvisionOnlyExistsValidator();
	}
}
