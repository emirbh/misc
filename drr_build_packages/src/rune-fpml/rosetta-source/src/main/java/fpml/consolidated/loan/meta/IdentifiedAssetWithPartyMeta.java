package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.IdentifiedAssetWithParty;
import fpml.consolidated.loan.validation.IdentifiedAssetWithPartyTypeFormatValidator;
import fpml.consolidated.loan.validation.IdentifiedAssetWithPartyValidator;
import fpml.consolidated.loan.validation.exists.IdentifiedAssetWithPartyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IdentifiedAssetWithParty.class)
public class IdentifiedAssetWithPartyMeta implements RosettaMetaData<IdentifiedAssetWithParty> {

	@Override
	public List<Validator<? super IdentifiedAssetWithParty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IdentifiedAssetWithParty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IdentifiedAssetWithParty> validator(ValidatorFactory factory) {
		return factory.<IdentifiedAssetWithParty>create(IdentifiedAssetWithPartyValidator.class);
	}

	@Override
	public Validator<? super IdentifiedAssetWithParty> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IdentifiedAssetWithParty>create(IdentifiedAssetWithPartyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IdentifiedAssetWithParty> validator() {
		return new IdentifiedAssetWithPartyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IdentifiedAssetWithParty> typeFormatValidator() {
		return new IdentifiedAssetWithPartyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IdentifiedAssetWithParty, Set<String>> onlyExistsValidator() {
		return new IdentifiedAssetWithPartyOnlyExistsValidator();
	}
}
