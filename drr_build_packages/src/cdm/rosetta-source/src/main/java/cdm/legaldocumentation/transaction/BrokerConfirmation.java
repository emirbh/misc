package cdm.legaldocumentation.transaction;

import cdm.legaldocumentation.transaction.meta.BrokerConfirmationMeta;
import cdm.legaldocumentation.transaction.metafields.FieldWithMetaBrokerConfirmationTypeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identifies the market sector in which the trade has been arranged.
 * @version 6.23.0
 */
@RosettaDataType(value="BrokerConfirmation", builder=BrokerConfirmation.BrokerConfirmationBuilderImpl.class, version="6.23.0")
@RuneDataType(value="BrokerConfirmation", model="cdm", builder=BrokerConfirmation.BrokerConfirmationBuilderImpl.class, version="6.23.0")
public interface BrokerConfirmation extends RosettaModelObject {

	BrokerConfirmationMeta metaData = new BrokerConfirmationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of broker confirmation executed between the parties.
	 */
	FieldWithMetaBrokerConfirmationTypeEnum getBrokerConfirmationType();

	/*********************** Build Methods  ***********************/
	BrokerConfirmation build();
	
	BrokerConfirmation.BrokerConfirmationBuilder toBuilder();
	
	static BrokerConfirmation.BrokerConfirmationBuilder builder() {
		return new BrokerConfirmation.BrokerConfirmationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BrokerConfirmation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BrokerConfirmation> getType() {
		return BrokerConfirmation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("brokerConfirmationType"), processor, FieldWithMetaBrokerConfirmationTypeEnum.class, getBrokerConfirmationType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BrokerConfirmationBuilder extends BrokerConfirmation, RosettaModelObjectBuilder {
		FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder getOrCreateBrokerConfirmationType();
		@Override
		FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder getBrokerConfirmationType();
		BrokerConfirmation.BrokerConfirmationBuilder setBrokerConfirmationType(FieldWithMetaBrokerConfirmationTypeEnum brokerConfirmationType);
		BrokerConfirmation.BrokerConfirmationBuilder setBrokerConfirmationTypeValue(BrokerConfirmationTypeEnum brokerConfirmationType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("brokerConfirmationType"), processor, FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder.class, getBrokerConfirmationType());
		}
		

		BrokerConfirmation.BrokerConfirmationBuilder prune();
	}

	/*********************** Immutable Implementation of BrokerConfirmation  ***********************/
	class BrokerConfirmationImpl implements BrokerConfirmation {
		private final FieldWithMetaBrokerConfirmationTypeEnum brokerConfirmationType;
		
		protected BrokerConfirmationImpl(BrokerConfirmation.BrokerConfirmationBuilder builder) {
			this.brokerConfirmationType = ofNullable(builder.getBrokerConfirmationType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("brokerConfirmationType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("brokerConfirmationType")
		public FieldWithMetaBrokerConfirmationTypeEnum getBrokerConfirmationType() {
			return brokerConfirmationType;
		}
		
		@Override
		public BrokerConfirmation build() {
			return this;
		}
		
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder toBuilder() {
			BrokerConfirmation.BrokerConfirmationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BrokerConfirmation.BrokerConfirmationBuilder builder) {
			ofNullable(getBrokerConfirmationType()).ifPresent(builder::setBrokerConfirmationType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BrokerConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(brokerConfirmationType, _that.getBrokerConfirmationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (brokerConfirmationType != null ? brokerConfirmationType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BrokerConfirmation {" +
				"brokerConfirmationType=" + this.brokerConfirmationType +
			'}';
		}
	}

	/*********************** Builder Implementation of BrokerConfirmation  ***********************/
	class BrokerConfirmationBuilderImpl implements BrokerConfirmation.BrokerConfirmationBuilder {
	
		protected FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder brokerConfirmationType;
		
		@Override
		@RosettaAttribute("brokerConfirmationType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("brokerConfirmationType")
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder getBrokerConfirmationType() {
			return brokerConfirmationType;
		}
		
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder getOrCreateBrokerConfirmationType() {
			FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder result;
			if (brokerConfirmationType!=null) {
				result = brokerConfirmationType;
			}
			else {
				result = brokerConfirmationType = FieldWithMetaBrokerConfirmationTypeEnum.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("brokerConfirmationType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("brokerConfirmationType")
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder setBrokerConfirmationType(FieldWithMetaBrokerConfirmationTypeEnum _brokerConfirmationType) {
			this.brokerConfirmationType = _brokerConfirmationType == null ? null : _brokerConfirmationType.toBuilder();
			return this;
		}
		
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder setBrokerConfirmationTypeValue(BrokerConfirmationTypeEnum _brokerConfirmationType) {
			this.getOrCreateBrokerConfirmationType().setValue(_brokerConfirmationType);
			return this;
		}
		
		@Override
		public BrokerConfirmation build() {
			return new BrokerConfirmation.BrokerConfirmationImpl(this);
		}
		
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder prune() {
			if (brokerConfirmationType!=null && !brokerConfirmationType.prune().hasData()) brokerConfirmationType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBrokerConfirmationType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BrokerConfirmation.BrokerConfirmationBuilder o = (BrokerConfirmation.BrokerConfirmationBuilder) other;
			
			merger.mergeRosetta(getBrokerConfirmationType(), o.getBrokerConfirmationType(), this::setBrokerConfirmationType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BrokerConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(brokerConfirmationType, _that.getBrokerConfirmationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (brokerConfirmationType != null ? brokerConfirmationType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BrokerConfirmationBuilder {" +
				"brokerConfirmationType=" + this.brokerConfirmationType +
			'}';
		}
	}
}
