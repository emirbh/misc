package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.FreightCommodityDry3;
import iso20022.auth030.hkma.dtcc.validation.FreightCommodityDry3TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.FreightCommodityDry3Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.FreightCommodityDry3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FreightCommodityDry3.class)
public class FreightCommodityDry3Meta implements RosettaMetaData<FreightCommodityDry3> {

	@Override
	public List<Validator<? super FreightCommodityDry3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FreightCommodityDry3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FreightCommodityDry3> validator(ValidatorFactory factory) {
		return factory.<FreightCommodityDry3>create(FreightCommodityDry3Validator.class);
	}

	@Override
	public Validator<? super FreightCommodityDry3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FreightCommodityDry3>create(FreightCommodityDry3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FreightCommodityDry3> validator() {
		return new FreightCommodityDry3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FreightCommodityDry3> typeFormatValidator() {
		return new FreightCommodityDry3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FreightCommodityDry3, Set<String>> onlyExistsValidator() {
		return new FreightCommodityDry3OnlyExistsValidator();
	}
}
