package fpml.consolidated.sec.lending;

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
import fpml.consolidated.repo.DeliveryMethod;
import fpml.consolidated.sec.lending.meta.SecLendTerminationMeta;
import fpml.consolidated.shared.IdentifiedDate;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Termination of the security lending transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Termination of the security lending transaction.
 *
 */
@RosettaDataType(value="SecLendTermination", builder=SecLendTermination.SecLendTerminationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SecLendTermination", model="fpml", builder=SecLendTermination.SecLendTerminationBuilderImpl.class, version="2.1.1")
public interface SecLendTermination extends SecLendTransferEvent {

	SecLendTerminationMeta metaData = new SecLendTerminationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SecLendTermination build();
	
	SecLendTermination.SecLendTerminationBuilder toBuilder();
	
	static SecLendTermination.SecLendTerminationBuilder builder() {
		return new SecLendTermination.SecLendTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecLendTermination> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecLendTermination> getType() {
		return SecLendTermination.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementDate"), processor, IdentifiedDate.class, getSettlementDate());
		processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.class, getDeliveryMethod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecLendTerminationBuilder extends SecLendTermination, SecLendTransferEvent.SecLendTransferEventBuilder {
		@Override
		SecLendTermination.SecLendTerminationBuilder setSettlementDate(IdentifiedDate settlementDate);
		@Override
		SecLendTermination.SecLendTerminationBuilder setDeliveryMethod(DeliveryMethod deliveryMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.DeliveryMethodBuilder.class, getDeliveryMethod());
		}
		

		SecLendTermination.SecLendTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of SecLendTermination  ***********************/
	class SecLendTerminationImpl extends SecLendTransferEvent.SecLendTransferEventImpl implements SecLendTermination {
		
		protected SecLendTerminationImpl(SecLendTermination.SecLendTerminationBuilder builder) {
			super(builder);
		}
		
		@Override
		public SecLendTermination build() {
			return this;
		}
		
		@Override
		public SecLendTermination.SecLendTerminationBuilder toBuilder() {
			SecLendTermination.SecLendTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecLendTermination.SecLendTerminationBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendTermination {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SecLendTermination  ***********************/
	class SecLendTerminationBuilderImpl extends SecLendTransferEvent.SecLendTransferEventBuilderImpl implements SecLendTermination.SecLendTerminationBuilder {
	
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public SecLendTermination.SecLendTerminationBuilder setSettlementDate(IdentifiedDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryMethod")
		@Override
		public SecLendTermination.SecLendTerminationBuilder setDeliveryMethod(DeliveryMethod _deliveryMethod) {
			this.deliveryMethod = _deliveryMethod == null ? null : _deliveryMethod.toBuilder();
			return this;
		}
		
		@Override
		public SecLendTermination build() {
			return new SecLendTermination.SecLendTerminationImpl(this);
		}
		
		@Override
		public SecLendTermination.SecLendTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendTermination.SecLendTerminationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendTermination.SecLendTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SecLendTermination.SecLendTerminationBuilder o = (SecLendTermination.SecLendTerminationBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendTerminationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
