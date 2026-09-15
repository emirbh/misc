package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.TradeCounterpartyRelationshipRecord1;
import iso20022.auth108.iso.validation.TradeCounterpartyRelationshipRecord1TypeFormatValidator;
import iso20022.auth108.iso.validation.TradeCounterpartyRelationshipRecord1Validator;
import iso20022.auth108.iso.validation.exists.TradeCounterpartyRelationshipRecord1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeCounterpartyRelationshipRecord1.class)
public class TradeCounterpartyRelationshipRecord1Meta implements RosettaMetaData<TradeCounterpartyRelationshipRecord1> {

	@Override
	public List<Validator<? super TradeCounterpartyRelationshipRecord1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeCounterpartyRelationshipRecord1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeCounterpartyRelationshipRecord1> validator(ValidatorFactory factory) {
		return factory.<TradeCounterpartyRelationshipRecord1>create(TradeCounterpartyRelationshipRecord1Validator.class);
	}

	@Override
	public Validator<? super TradeCounterpartyRelationshipRecord1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeCounterpartyRelationshipRecord1>create(TradeCounterpartyRelationshipRecord1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeCounterpartyRelationshipRecord1> validator() {
		return new TradeCounterpartyRelationshipRecord1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeCounterpartyRelationshipRecord1> typeFormatValidator() {
		return new TradeCounterpartyRelationshipRecord1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeCounterpartyRelationshipRecord1, Set<String>> onlyExistsValidator() {
		return new TradeCounterpartyRelationshipRecord1OnlyExistsValidator();
	}
}
