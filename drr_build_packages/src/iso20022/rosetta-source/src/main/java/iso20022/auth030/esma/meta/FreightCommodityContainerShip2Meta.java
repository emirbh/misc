package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.FreightCommodityContainerShip2;
import iso20022.auth030.esma.validation.FreightCommodityContainerShip2TypeFormatValidator;
import iso20022.auth030.esma.validation.FreightCommodityContainerShip2Validator;
import iso20022.auth030.esma.validation.exists.FreightCommodityContainerShip2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FreightCommodityContainerShip2.class)
public class FreightCommodityContainerShip2Meta implements RosettaMetaData<FreightCommodityContainerShip2> {

	@Override
	public List<Validator<? super FreightCommodityContainerShip2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FreightCommodityContainerShip2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FreightCommodityContainerShip2> validator(ValidatorFactory factory) {
		return factory.<FreightCommodityContainerShip2>create(FreightCommodityContainerShip2Validator.class);
	}

	@Override
	public Validator<? super FreightCommodityContainerShip2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FreightCommodityContainerShip2>create(FreightCommodityContainerShip2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FreightCommodityContainerShip2> validator() {
		return new FreightCommodityContainerShip2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FreightCommodityContainerShip2> typeFormatValidator() {
		return new FreightCommodityContainerShip2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FreightCommodityContainerShip2, Set<String>> onlyExistsValidator() {
		return new FreightCommodityContainerShip2OnlyExistsValidator();
	}
}
