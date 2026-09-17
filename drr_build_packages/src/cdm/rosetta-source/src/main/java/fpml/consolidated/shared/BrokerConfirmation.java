package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.BrokerConfirmationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Identifies the market sector in which the trade has been arranged.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identifies the market sector in which the trade has been arranged.
 *
 */
@RosettaDataType(value="BrokerConfirmation", builder=BrokerConfirmation.BrokerConfirmationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BrokerConfirmation", model="fpml", builder=BrokerConfirmation.BrokerConfirmationBuilderImpl.class, version="2.1.1")
public interface BrokerConfirmation extends RosettaModelObject {

	BrokerConfirmationMeta metaData = new BrokerConfirmationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of broker confirmation executed between the parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of broker confirmation executed between the parties.
	 *
	 */
	BrokerConfirmationType getBrokerConfirmationType();

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
		processRosetta(path.newSubPath("brokerConfirmationType"), processor, BrokerConfirmationType.class, getBrokerConfirmationType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BrokerConfirmationBuilder extends BrokerConfirmation, RosettaModelObjectBuilder {
		BrokerConfirmationType.BrokerConfirmationTypeBuilder getOrCreateBrokerConfirmationType();
		@Override
		BrokerConfirmationType.BrokerConfirmationTypeBuilder getBrokerConfirmationType();
		BrokerConfirmation.BrokerConfirmationBuilder setBrokerConfirmationType(BrokerConfirmationType brokerConfirmationType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("brokerConfirmationType"), processor, BrokerConfirmationType.BrokerConfirmationTypeBuilder.class, getBrokerConfirmationType());
		}
		

		BrokerConfirmation.BrokerConfirmationBuilder prune();
	}

	/*********************** Immutable Implementation of BrokerConfirmation  ***********************/
	class BrokerConfirmationImpl implements BrokerConfirmation {
		private final BrokerConfirmationType brokerConfirmationType;
		
		protected BrokerConfirmationImpl(BrokerConfirmation.BrokerConfirmationBuilder builder) {
			this.brokerConfirmationType = ofNullable(builder.getBrokerConfirmationType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("brokerConfirmationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerConfirmationType")
		public BrokerConfirmationType getBrokerConfirmationType() {
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
	
		protected BrokerConfirmationType.BrokerConfirmationTypeBuilder brokerConfirmationType;
		
		@Override
		@RosettaAttribute("brokerConfirmationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerConfirmationType")
		public BrokerConfirmationType.BrokerConfirmationTypeBuilder getBrokerConfirmationType() {
			return brokerConfirmationType;
		}
		
		@Override
		public BrokerConfirmationType.BrokerConfirmationTypeBuilder getOrCreateBrokerConfirmationType() {
			BrokerConfirmationType.BrokerConfirmationTypeBuilder result;
			if (brokerConfirmationType!=null) {
				result = brokerConfirmationType;
			}
			else {
				result = brokerConfirmationType = BrokerConfirmationType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("brokerConfirmationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerConfirmationType")
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder setBrokerConfirmationType(BrokerConfirmationType _brokerConfirmationType) {
			this.brokerConfirmationType = _brokerConfirmationType == null ? null : _brokerConfirmationType.toBuilder();
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
			if (getBrokerConfirmationType()!=null && getBrokerConfirmationType().hasData()) return true;
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
