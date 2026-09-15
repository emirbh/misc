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
import fpml.consolidated.sec.lending.meta.SecLendTransferEventMeta;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Abstract base type for initiation, termination events.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Abstract base type for initiation, termination events.
 *
 */
@RosettaDataType(value="SecLendTransferEvent", builder=SecLendTransferEvent.SecLendTransferEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SecLendTransferEvent", model="fpml", builder=SecLendTransferEvent.SecLendTransferEventBuilderImpl.class, version="2.1.1")
public interface SecLendTransferEvent extends RosettaModelObject {

	SecLendTransferEventMeta metaData = new SecLendTransferEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Security transfer settlement date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Security transfer settlement date.
	 *
	 */
	IdentifiedDate getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a delivery method for the principal security in the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a delivery method for the principal security in the transaction.
	 *
	 */
	DeliveryMethod getDeliveryMethod();

	/*********************** Build Methods  ***********************/
	SecLendTransferEvent build();
	
	SecLendTransferEvent.SecLendTransferEventBuilder toBuilder();
	
	static SecLendTransferEvent.SecLendTransferEventBuilder builder() {
		return new SecLendTransferEvent.SecLendTransferEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecLendTransferEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecLendTransferEvent> getType() {
		return SecLendTransferEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementDate"), processor, IdentifiedDate.class, getSettlementDate());
		processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.class, getDeliveryMethod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecLendTransferEventBuilder extends SecLendTransferEvent, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateSettlementDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getSettlementDate();
		DeliveryMethod.DeliveryMethodBuilder getOrCreateDeliveryMethod();
		@Override
		DeliveryMethod.DeliveryMethodBuilder getDeliveryMethod();
		SecLendTransferEvent.SecLendTransferEventBuilder setSettlementDate(IdentifiedDate settlementDate);
		SecLendTransferEvent.SecLendTransferEventBuilder setDeliveryMethod(DeliveryMethod deliveryMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.DeliveryMethodBuilder.class, getDeliveryMethod());
		}
		

		SecLendTransferEvent.SecLendTransferEventBuilder prune();
	}

	/*********************** Immutable Implementation of SecLendTransferEvent  ***********************/
	class SecLendTransferEventImpl implements SecLendTransferEvent {
		private final IdentifiedDate settlementDate;
		private final DeliveryMethod deliveryMethod;
		
		protected SecLendTransferEventImpl(SecLendTransferEvent.SecLendTransferEventBuilder builder) {
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.deliveryMethod = ofNullable(builder.getDeliveryMethod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementDate")
		public IdentifiedDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("deliveryMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryMethod")
		public DeliveryMethod getDeliveryMethod() {
			return deliveryMethod;
		}
		
		@Override
		public SecLendTransferEvent build() {
			return this;
		}
		
		@Override
		public SecLendTransferEvent.SecLendTransferEventBuilder toBuilder() {
			SecLendTransferEvent.SecLendTransferEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecLendTransferEvent.SecLendTransferEventBuilder builder) {
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getDeliveryMethod()).ifPresent(builder::setDeliveryMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecLendTransferEvent _that = getType().cast(o);
		
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(deliveryMethod, _that.getDeliveryMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (deliveryMethod != null ? deliveryMethod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendTransferEvent {" +
				"settlementDate=" + this.settlementDate + ", " +
				"deliveryMethod=" + this.deliveryMethod +
			'}';
		}
	}

	/*********************** Builder Implementation of SecLendTransferEvent  ***********************/
	class SecLendTransferEventBuilderImpl implements SecLendTransferEvent.SecLendTransferEventBuilder {
	
		protected IdentifiedDate.IdentifiedDateBuilder settlementDate;
		protected DeliveryMethod.DeliveryMethodBuilder deliveryMethod;
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementDate")
		public IdentifiedDate.IdentifiedDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateSettlementDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryMethod")
		public DeliveryMethod.DeliveryMethodBuilder getDeliveryMethod() {
			return deliveryMethod;
		}
		
		@Override
		public DeliveryMethod.DeliveryMethodBuilder getOrCreateDeliveryMethod() {
			DeliveryMethod.DeliveryMethodBuilder result;
			if (deliveryMethod!=null) {
				result = deliveryMethod;
			}
			else {
				result = deliveryMethod = DeliveryMethod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public SecLendTransferEvent.SecLendTransferEventBuilder setSettlementDate(IdentifiedDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryMethod")
		@Override
		public SecLendTransferEvent.SecLendTransferEventBuilder setDeliveryMethod(DeliveryMethod _deliveryMethod) {
			this.deliveryMethod = _deliveryMethod == null ? null : _deliveryMethod.toBuilder();
			return this;
		}
		
		@Override
		public SecLendTransferEvent build() {
			return new SecLendTransferEvent.SecLendTransferEventImpl(this);
		}
		
		@Override
		public SecLendTransferEvent.SecLendTransferEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendTransferEvent.SecLendTransferEventBuilder prune() {
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (deliveryMethod!=null && !deliveryMethod.prune().hasData()) deliveryMethod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getDeliveryMethod()!=null && getDeliveryMethod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendTransferEvent.SecLendTransferEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecLendTransferEvent.SecLendTransferEventBuilder o = (SecLendTransferEvent.SecLendTransferEventBuilder) other;
			
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getDeliveryMethod(), o.getDeliveryMethod(), this::setDeliveryMethod);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecLendTransferEvent _that = getType().cast(o);
		
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(deliveryMethod, _that.getDeliveryMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (deliveryMethod != null ? deliveryMethod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendTransferEventBuilder {" +
				"settlementDate=" + this.settlementDate + ", " +
				"deliveryMethod=" + this.deliveryMethod +
			'}';
		}
	}
}
