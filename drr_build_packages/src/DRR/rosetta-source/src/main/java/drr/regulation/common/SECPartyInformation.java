package drr.regulation.common;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import drr.regulation.common.meta.SECPartyInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Enriched party information required for reporting a transaction to the CFTC.
 * @version 7.7.0
 */
@RosettaDataType(value="SECPartyInformation", builder=SECPartyInformation.SECPartyInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="SECPartyInformation", model="drr", builder=SECPartyInformation.SECPartyInformationBuilderImpl.class, version="7.7.0")
public interface SECPartyInformation extends RosettaModelObject {

	SECPartyInformationMeta metaData = new SECPartyInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicator of whether counterparty is a financial entity, and which type.
	 */
	CFTCFinancialEntityClassificationEnum getFinancialEntity();

	/*********************** Build Methods  ***********************/
	SECPartyInformation build();
	
	SECPartyInformation.SECPartyInformationBuilder toBuilder();
	
	static SECPartyInformation.SECPartyInformationBuilder builder() {
		return new SECPartyInformation.SECPartyInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SECPartyInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SECPartyInformation> getType() {
		return SECPartyInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("financialEntity"), CFTCFinancialEntityClassificationEnum.class, getFinancialEntity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SECPartyInformationBuilder extends SECPartyInformation, RosettaModelObjectBuilder {
		SECPartyInformation.SECPartyInformationBuilder setFinancialEntity(CFTCFinancialEntityClassificationEnum financialEntity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("financialEntity"), CFTCFinancialEntityClassificationEnum.class, getFinancialEntity(), this);
		}
		

		SECPartyInformation.SECPartyInformationBuilder prune();
	}

	/*********************** Immutable Implementation of SECPartyInformation  ***********************/
	class SECPartyInformationImpl implements SECPartyInformation {
		private final CFTCFinancialEntityClassificationEnum financialEntity;
		
		protected SECPartyInformationImpl(SECPartyInformation.SECPartyInformationBuilder builder) {
			this.financialEntity = builder.getFinancialEntity();
		}
		
		@Override
		@RosettaAttribute("financialEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("financialEntity")
		public CFTCFinancialEntityClassificationEnum getFinancialEntity() {
			return financialEntity;
		}
		
		@Override
		public SECPartyInformation build() {
			return this;
		}
		
		@Override
		public SECPartyInformation.SECPartyInformationBuilder toBuilder() {
			SECPartyInformation.SECPartyInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SECPartyInformation.SECPartyInformationBuilder builder) {
			ofNullable(getFinancialEntity()).ifPresent(builder::setFinancialEntity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SECPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(financialEntity, _that.getFinancialEntity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (financialEntity != null ? financialEntity.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SECPartyInformation {" +
				"financialEntity=" + this.financialEntity +
			'}';
		}
	}

	/*********************** Builder Implementation of SECPartyInformation  ***********************/
	class SECPartyInformationBuilderImpl implements SECPartyInformation.SECPartyInformationBuilder {
	
		protected CFTCFinancialEntityClassificationEnum financialEntity;
		
		@Override
		@RosettaAttribute("financialEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("financialEntity")
		public CFTCFinancialEntityClassificationEnum getFinancialEntity() {
			return financialEntity;
		}
		
		@RosettaAttribute("financialEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("financialEntity")
		@Override
		public SECPartyInformation.SECPartyInformationBuilder setFinancialEntity(CFTCFinancialEntityClassificationEnum _financialEntity) {
			this.financialEntity = _financialEntity == null ? null : _financialEntity;
			return this;
		}
		
		@Override
		public SECPartyInformation build() {
			return new SECPartyInformation.SECPartyInformationImpl(this);
		}
		
		@Override
		public SECPartyInformation.SECPartyInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SECPartyInformation.SECPartyInformationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFinancialEntity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SECPartyInformation.SECPartyInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SECPartyInformation.SECPartyInformationBuilder o = (SECPartyInformation.SECPartyInformationBuilder) other;
			
			
			merger.mergeBasic(getFinancialEntity(), o.getFinancialEntity(), this::setFinancialEntity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SECPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(financialEntity, _that.getFinancialEntity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (financialEntity != null ? financialEntity.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SECPartyInformationBuilder {" +
				"financialEntity=" + this.financialEntity +
			'}';
		}
	}
}
