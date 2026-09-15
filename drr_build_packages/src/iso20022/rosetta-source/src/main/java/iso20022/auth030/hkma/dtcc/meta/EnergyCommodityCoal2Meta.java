package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.EnergyCommodityCoal2;
import iso20022.auth030.hkma.dtcc.validation.EnergyCommodityCoal2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.EnergyCommodityCoal2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.EnergyCommodityCoal2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EnergyCommodityCoal2.class)
public class EnergyCommodityCoal2Meta implements RosettaMetaData<EnergyCommodityCoal2> {

	@Override
	public List<Validator<? super EnergyCommodityCoal2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnergyCommodityCoal2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnergyCommodityCoal2> validator(ValidatorFactory factory) {
		return factory.<EnergyCommodityCoal2>create(EnergyCommodityCoal2Validator.class);
	}

	@Override
	public Validator<? super EnergyCommodityCoal2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnergyCommodityCoal2>create(EnergyCommodityCoal2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityCoal2> validator() {
		return new EnergyCommodityCoal2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super EnergyCommodityCoal2> typeFormatValidator() {
		return new EnergyCommodityCoal2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnergyCommodityCoal2, Set<String>> onlyExistsValidator() {
		return new EnergyCommodityCoal2OnlyExistsValidator();
	}
}
