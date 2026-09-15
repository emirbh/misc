package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.EnergyCommodityRenewableEnergy2;
import iso20022.auth030.hkma.dtcc.validation.EnergyCommodityRenewableEnergy2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.EnergyCommodityRenewableEnergy2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.EnergyCommodityRenewableEnergy2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnergyCommodityRenewableEnergy2.class)
public class EnergyCommodityRenewableEnergy2Meta implements RosettaMetaData<EnergyCommodityRenewableEnergy2> {

	@Override
	public List<Validator<? super EnergyCommodityRenewableEnergy2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnergyCommodityRenewableEnergy2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnergyCommodityRenewableEnergy2> validator(ValidatorFactory factory) {
		return factory.<EnergyCommodityRenewableEnergy2>create(EnergyCommodityRenewableEnergy2Validator.class);
	}

	@Override
	public Validator<? super EnergyCommodityRenewableEnergy2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnergyCommodityRenewableEnergy2>create(EnergyCommodityRenewableEnergy2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityRenewableEnergy2> validator() {
		return new EnergyCommodityRenewableEnergy2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityRenewableEnergy2> typeFormatValidator() {
		return new EnergyCommodityRenewableEnergy2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnergyCommodityRenewableEnergy2, Set<String>> onlyExistsValidator() {
		return new EnergyCommodityRenewableEnergy2OnlyExistsValidator();
	}
}
