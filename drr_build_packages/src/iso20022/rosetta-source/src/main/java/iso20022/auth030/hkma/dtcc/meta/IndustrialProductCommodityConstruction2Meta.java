package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.IndustrialProductCommodityConstruction2;
import iso20022.auth030.hkma.dtcc.validation.IndustrialProductCommodityConstruction2TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.IndustrialProductCommodityConstruction2Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.IndustrialProductCommodityConstruction2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IndustrialProductCommodityConstruction2.class)
public class IndustrialProductCommodityConstruction2Meta implements RosettaMetaData<IndustrialProductCommodityConstruction2> {

	@Override
	public List<Validator<? super IndustrialProductCommodityConstruction2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndustrialProductCommodityConstruction2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IndustrialProductCommodityConstruction2> validator(ValidatorFactory factory) {
		return factory.<IndustrialProductCommodityConstruction2>create(IndustrialProductCommodityConstruction2Validator.class);
	}

	@Override
	public Validator<? super IndustrialProductCommodityConstruction2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IndustrialProductCommodityConstruction2>create(IndustrialProductCommodityConstruction2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IndustrialProductCommodityConstruction2> validator() {
		return new IndustrialProductCommodityConstruction2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super IndustrialProductCommodityConstruction2> typeFormatValidator() {
		return new IndustrialProductCommodityConstruction2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndustrialProductCommodityConstruction2, Set<String>> onlyExistsValidator() {
		return new IndustrialProductCommodityConstruction2OnlyExistsValidator();
	}
}
