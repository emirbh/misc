package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.FxTargetRebateMeta;
import fpml.consolidated.shared.SimplePayment;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A rebate can be expressed as a payment amount or as amount of outstanding gain.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A rebate can be expressed as a payment amount or as amount of outstanding gain.
 *
 */
@RosettaDataType(value="FxTargetRebate", builder=FxTargetRebate.FxTargetRebateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetRebate", model="fpml", builder=FxTargetRebate.FxTargetRebateBuilderImpl.class, version="2.1.1")
public interface FxTargetRebate extends RosettaModelObject {

	FxTargetRebateMeta metaData = new FxTargetRebateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Rebate amount expressed as a payment between the two parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Rebate amount expressed as a payment between the two parties.
	 *
	 */
	SimplePayment getPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Rebate expressed as amount of outstanding gain.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Rebate expressed as amount of outstanding gain.
	 *
	 */
	FxOutstandingGain getOutstandingGain();

	/*********************** Build Methods  ***********************/
	FxTargetRebate build();
	
	FxTargetRebate.FxTargetRebateBuilder toBuilder();
	
	static FxTargetRebate.FxTargetRebateBuilder builder() {
		return new FxTargetRebate.FxTargetRebateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetRebate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetRebate> getType() {
		return FxTargetRebate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payment"), processor, SimplePayment.class, getPayment());
		processRosetta(path.newSubPath("outstandingGain"), processor, FxOutstandingGain.class, getOutstandingGain());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetRebateBuilder extends FxTargetRebate, RosettaModelObjectBuilder {
		SimplePayment.SimplePaymentBuilder getOrCreatePayment();
		@Override
		SimplePayment.SimplePaymentBuilder getPayment();
		FxOutstandingGain.FxOutstandingGainBuilder getOrCreateOutstandingGain();
		@Override
		FxOutstandingGain.FxOutstandingGainBuilder getOutstandingGain();
		FxTargetRebate.FxTargetRebateBuilder setPayment(SimplePayment payment);
		FxTargetRebate.FxTargetRebateBuilder setOutstandingGain(FxOutstandingGain outstandingGain);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payment"), processor, SimplePayment.SimplePaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("outstandingGain"), processor, FxOutstandingGain.FxOutstandingGainBuilder.class, getOutstandingGain());
		}
		

		FxTargetRebate.FxTargetRebateBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetRebate  ***********************/
	class FxTargetRebateImpl implements FxTargetRebate {
		private final SimplePayment payment;
		private final FxOutstandingGain outstandingGain;
		
		protected FxTargetRebateImpl(FxTargetRebate.FxTargetRebateBuilder builder) {
			this.payment = ofNullable(builder.getPayment()).map(f->f.build()).orElse(null);
			this.outstandingGain = ofNullable(builder.getOutstandingGain()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public SimplePayment getPayment() {
			return payment;
		}
		
		@Override
		@RosettaAttribute("outstandingGain")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingGain")
		public FxOutstandingGain getOutstandingGain() {
			return outstandingGain;
		}
		
		@Override
		public FxTargetRebate build() {
			return this;
		}
		
		@Override
		public FxTargetRebate.FxTargetRebateBuilder toBuilder() {
			FxTargetRebate.FxTargetRebateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetRebate.FxTargetRebateBuilder builder) {
			ofNullable(getPayment()).ifPresent(builder::setPayment);
			ofNullable(getOutstandingGain()).ifPresent(builder::setOutstandingGain);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRebate _that = getType().cast(o);
		
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(outstandingGain, _that.getOutstandingGain())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (outstandingGain != null ? outstandingGain.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetRebate {" +
				"payment=" + this.payment + ", " +
				"outstandingGain=" + this.outstandingGain +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetRebate  ***********************/
	class FxTargetRebateBuilderImpl implements FxTargetRebate.FxTargetRebateBuilder {
	
		protected SimplePayment.SimplePaymentBuilder payment;
		protected FxOutstandingGain.FxOutstandingGainBuilder outstandingGain;
		
		@Override
		@RosettaAttribute("payment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payment")
		public SimplePayment.SimplePaymentBuilder getPayment() {
			return payment;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreatePayment() {
			SimplePayment.SimplePaymentBuilder result;
			if (payment!=null) {
				result = payment;
			}
			else {
				result = payment = SimplePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingGain")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingGain")
		public FxOutstandingGain.FxOutstandingGainBuilder getOutstandingGain() {
			return outstandingGain;
		}
		
		@Override
		public FxOutstandingGain.FxOutstandingGainBuilder getOrCreateOutstandingGain() {
			FxOutstandingGain.FxOutstandingGainBuilder result;
			if (outstandingGain!=null) {
				result = outstandingGain;
			}
			else {
				result = outstandingGain = FxOutstandingGain.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payment")
		@Override
		public FxTargetRebate.FxTargetRebateBuilder setPayment(SimplePayment _payment) {
			this.payment = _payment == null ? null : _payment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("outstandingGain")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingGain")
		@Override
		public FxTargetRebate.FxTargetRebateBuilder setOutstandingGain(FxOutstandingGain _outstandingGain) {
			this.outstandingGain = _outstandingGain == null ? null : _outstandingGain.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetRebate build() {
			return new FxTargetRebate.FxTargetRebateImpl(this);
		}
		
		@Override
		public FxTargetRebate.FxTargetRebateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRebate.FxTargetRebateBuilder prune() {
			if (payment!=null && !payment.prune().hasData()) payment = null;
			if (outstandingGain!=null && !outstandingGain.prune().hasData()) outstandingGain = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayment()!=null && getPayment().hasData()) return true;
			if (getOutstandingGain()!=null && getOutstandingGain().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRebate.FxTargetRebateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetRebate.FxTargetRebateBuilder o = (FxTargetRebate.FxTargetRebateBuilder) other;
			
			merger.mergeRosetta(getPayment(), o.getPayment(), this::setPayment);
			merger.mergeRosetta(getOutstandingGain(), o.getOutstandingGain(), this::setOutstandingGain);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRebate _that = getType().cast(o);
		
			if (!Objects.equals(payment, _that.getPayment())) return false;
			if (!Objects.equals(outstandingGain, _that.getOutstandingGain())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payment != null ? payment.hashCode() : 0);
			_result = 31 * _result + (outstandingGain != null ? outstandingGain.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetRebateBuilder {" +
				"payment=" + this.payment + ", " +
				"outstandingGain=" + this.outstandingGain +
			'}';
		}
	}
}
