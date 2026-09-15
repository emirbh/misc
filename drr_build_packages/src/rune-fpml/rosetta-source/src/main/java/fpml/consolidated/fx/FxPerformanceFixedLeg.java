package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FxPerformanceFixedLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision FX Performance Fixed Leg describes Fixed FX Rate Payer and Fixed Rate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision FX Performance Fixed Leg describes Fixed FX Rate Payer and Fixed Rate.
 *
 */
@RosettaDataType(value="FxPerformanceFixedLeg", builder=FxPerformanceFixedLeg.FxPerformanceFixedLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxPerformanceFixedLeg", model="fpml", builder=FxPerformanceFixedLeg.FxPerformanceFixedLegBuilderImpl.class, version="2.1.1")
public interface FxPerformanceFixedLeg extends FxPerformanceLeg {

	FxPerformanceFixedLegMeta metaData = new FxPerformanceFixedLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fixed Rate means a rate, expressed as a decimal, equal to the per annum rate specified as such in the Confirmation for the Non-Deliverable Swap FX Transaction or that party (i.e., a per annum rate of 15.10% as specified in a Confirmation shall be expressed as 0.1510 for calculation purposes).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Fixed Rate means a rate, expressed as a decimal, equal to the per annum rate specified as such in the Confirmation for the Non-Deliverable Swap FX Transaction or that party (i.e., a per annum rate of 15.10% as specified in a Confirmation shall be expressed as 0.1510 for calculation purposes).
	 *
	 */
	BigDecimal getFixedRate();

	/*********************** Build Methods  ***********************/
	FxPerformanceFixedLeg build();
	
	FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder toBuilder();
	
	static FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder builder() {
		return new FxPerformanceFixedLeg.FxPerformanceFixedLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPerformanceFixedLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxPerformanceFixedLeg> getType() {
		return FxPerformanceFixedLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPerformanceFixedLegBuilder extends FxPerformanceFixedLeg, FxPerformanceLeg.FxPerformanceLegBuilder {
		@Override
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setFixedRate(BigDecimal fixedRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		}
		

		FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder prune();
	}

	/*********************** Immutable Implementation of FxPerformanceFixedLeg  ***********************/
	class FxPerformanceFixedLegImpl extends FxPerformanceLeg.FxPerformanceLegImpl implements FxPerformanceFixedLeg {
		private final BigDecimal fixedRate;
		
		protected FxPerformanceFixedLegImpl(FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder builder) {
			super(builder);
			this.fixedRate = builder.getFixedRate();
		}
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@Override
		public FxPerformanceFixedLeg build() {
			return this;
		}
		
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder toBuilder() {
			FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedRate()).ifPresent(builder::setFixedRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxPerformanceFixedLeg _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPerformanceFixedLeg {" +
				"fixedRate=" + this.fixedRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxPerformanceFixedLeg  ***********************/
	class FxPerformanceFixedLegBuilderImpl extends FxPerformanceLeg.FxPerformanceLegBuilderImpl implements FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder {
	
		protected BigDecimal fixedRate;
		
		@Override
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fixedRate")
		public BigDecimal getFixedRate() {
			return fixedRate;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fixedRate")
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder setFixedRate(BigDecimal _fixedRate) {
			this.fixedRate = _fixedRate == null ? null : _fixedRate;
			return this;
		}
		
		@Override
		public FxPerformanceFixedLeg build() {
			return new FxPerformanceFixedLeg.FxPerformanceFixedLegImpl(this);
		}
		
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder o = (FxPerformanceFixedLeg.FxPerformanceFixedLegBuilder) other;
			
			
			merger.mergeBasic(getFixedRate(), o.getFixedRate(), this::setFixedRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxPerformanceFixedLeg _that = getType().cast(o);
		
			if (!Objects.equals(fixedRate, _that.getFixedRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRate != null ? fixedRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPerformanceFixedLegBuilder {" +
				"fixedRate=" + this.fixedRate +
			'}' + " " + super.toString();
		}
	}
}
