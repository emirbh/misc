package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.EnergyCommodityElectricity2;
import iso20022.auth030.esma.validation.EnergyCommodityElectricity2TypeFormatValidator;
import iso20022.auth030.esma.validation.EnergyCommodityElectricity2Validator;
import iso20022.auth030.esma.validation.exists.EnergyCommodityElectricity2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnergyCommodityElectricity2.class)
public class EnergyCommodityElectricity2Meta implements RosettaMetaData<EnergyCommodityElectricity2> {

	@Override
	public List<Validator<? super EnergyCommodityElectricity2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnergyCommodityElectricity2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnergyCommodityElectricity2> validator(ValidatorFactory factory) {
		return factory.<EnergyCommodityElectricity2>create(EnergyCommodityElectricity2Validator.class);
	}

	@Override
	public Validator<? super EnergyCommodityElectricity2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnergyCommodityElectricity2>create(EnergyCommodityElectricity2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityElectricity2> validator() {
		return new EnergyCommodityElectricity2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityElectricity2> typeFormatValidator() {
		return new EnergyCommodityElectricity2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnergyCommodityElectricity2, Set<String>> onlyExistsValidator() {
		return new EnergyCommodityElectricity2OnlyExistsValidator();
	}
}
