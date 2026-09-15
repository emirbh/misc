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
import fpml.consolidated.fx.meta.FxPerformanceFloatingLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Fx Performance Floating Leg describes Floating FX Rate Payer.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Fx Performance Floating Leg describes Floating FX Rate Payer.
 *
 */
@RosettaDataType(value="FxPerformanceFloatingLeg", builder=FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxPerformanceFloatingLeg", model="fpml", builder=FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilderImpl.class, version="2.1.1")
public interface FxPerformanceFloatingLeg extends FxPerformanceLeg {

	FxPerformanceFloatingLegMeta metaData = new FxPerformanceFloatingLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxPerformanceFloatingLeg build();
	
	FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder toBuilder();
	
	static FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder builder() {
		return new FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPerformanceFloatingLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxPerformanceFloatingLeg> getType() {
		return FxPerformanceFloatingLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPerformanceFloatingLegBuilder extends FxPerformanceFloatingLeg, FxPerformanceLeg.FxPerformanceLegBuilder {
		@Override
		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
		}
		

		FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder prune();
	}

	/*********************** Immutable Implementation of FxPerformanceFloatingLeg  ***********************/
	class FxPerformanceFloatingLegImpl extends FxPerformanceLeg.FxPerformanceLegImpl implements FxPerformanceFloatingLeg {
		
		protected FxPerformanceFloatingLegImpl(FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxPerformanceFloatingLeg build() {
			return this;
		}
		
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder toBuilder() {
			FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder builder) {
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
			return "FxPerformanceFloatingLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxPerformanceFloatingLeg  ***********************/
	class FxPerformanceFloatingLegBuilderImpl extends FxPerformanceLeg.FxPerformanceLegBuilderImpl implements FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder {
	
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public FxPerformanceFloatingLeg build() {
			return new FxPerformanceFloatingLeg.FxPerformanceFloatingLegImpl(this);
		}
		
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder prune() {
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
		public FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder o = (FxPerformanceFloatingLeg.FxPerformanceFloatingLegBuilder) other;
			
			
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
			return "FxPerformanceFloatingLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
