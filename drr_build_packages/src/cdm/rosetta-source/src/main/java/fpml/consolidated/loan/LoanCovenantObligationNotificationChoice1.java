package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanCovenantObligationNotificationChoice1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="LoanCovenantObligationNotificationChoice1", builder=LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1BuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationNotificationChoice1", model="fpml", builder=LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1BuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationNotificationChoice1 extends RosettaModelObject {

	LoanCovenantObligationNotificationChoice1Meta metaData = new LoanCovenantObligationNotificationChoice1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A deal identifier structure.
	 *
	 */
	CovenantObligationIdentifier getCovenantIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LoanCovenantObligationSummary getCovenantSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LoanCovenantObligation getCovenant();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationNotificationChoice1 build();
	
	LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder toBuilder();
	
	static LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder builder() {
		return new LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationNotificationChoice1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationNotificationChoice1> getType() {
		return LoanCovenantObligationNotificationChoice1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("covenantIdentifier"), processor, CovenantObligationIdentifier.class, getCovenantIdentifier());
		processRosetta(path.newSubPath("covenantSummary"), processor, LoanCovenantObligationSummary.class, getCovenantSummary());
		processRosetta(path.newSubPath("covenant"), processor, LoanCovenantObligation.class, getCovenant());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationNotificationChoice1Builder extends LoanCovenantObligationNotificationChoice1, RosettaModelObjectBuilder {
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder getOrCreateCovenantIdentifier();
		@Override
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder getCovenantIdentifier();
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder getOrCreateCovenantSummary();
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder getCovenantSummary();
		LoanCovenantObligation.LoanCovenantObligationBuilder getOrCreateCovenant();
		@Override
		LoanCovenantObligation.LoanCovenantObligationBuilder getCovenant();
		LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder setCovenantIdentifier(CovenantObligationIdentifier covenantIdentifier);
		LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder setCovenantSummary(LoanCovenantObligationSummary covenantSummary);
		LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder setCovenant(LoanCovenantObligation covenant);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("covenantIdentifier"), processor, CovenantObligationIdentifier.CovenantObligationIdentifierBuilder.class, getCovenantIdentifier());
			processRosetta(path.newSubPath("covenantSummary"), processor, LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder.class, getCovenantSummary());
			processRosetta(path.newSubPath("covenant"), processor, LoanCovenantObligation.LoanCovenantObligationBuilder.class, getCovenant());
		}
		

		LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationNotificationChoice1  ***********************/
	class LoanCovenantObligationNotificationChoice1Impl implements LoanCovenantObligationNotificationChoice1 {
		private final CovenantObligationIdentifier covenantIdentifier;
		private final LoanCovenantObligationSummary covenantSummary;
		private final LoanCovenantObligation covenant;
		
		protected LoanCovenantObligationNotificationChoice1Impl(LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder builder) {
			this.covenantIdentifier = ofNullable(builder.getCovenantIdentifier()).map(f->f.build()).orElse(null);
			this.covenantSummary = ofNullable(builder.getCovenantSummary()).map(f->f.build()).orElse(null);
			this.covenant = ofNullable(builder.getCovenant()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("covenantIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("covenantIdentifier")
		public CovenantObligationIdentifier getCovenantIdentifier() {
			return covenantIdentifier;
		}
		
		@Override
		@RosettaAttribute("covenantSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("covenantSummary")
		public LoanCovenantObligationSummary getCovenantSummary() {
			return covenantSummary;
		}
		
		@Override
		@RosettaAttribute("covenant")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("covenant")
		public LoanCovenantObligation getCovenant() {
			return covenant;
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice1 build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder toBuilder() {
			LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder builder) {
			ofNullable(getCovenantIdentifier()).ifPresent(builder::setCovenantIdentifier);
			ofNullable(getCovenantSummary()).ifPresent(builder::setCovenantSummary);
			ofNullable(getCovenant()).ifPresent(builder::setCovenant);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationNotificationChoice1 _that = getType().cast(o);
		
			if (!Objects.equals(covenantIdentifier, _that.getCovenantIdentifier())) return false;
			if (!Objects.equals(covenantSummary, _that.getCovenantSummary())) return false;
			if (!Objects.equals(covenant, _that.getCovenant())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (covenantIdentifier != null ? covenantIdentifier.hashCode() : 0);
			_result = 31 * _result + (covenantSummary != null ? covenantSummary.hashCode() : 0);
			_result = 31 * _result + (covenant != null ? covenant.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationNotificationChoice1 {" +
				"covenantIdentifier=" + this.covenantIdentifier + ", " +
				"covenantSummary=" + this.covenantSummary + ", " +
				"covenant=" + this.covenant +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationNotificationChoice1  ***********************/
	class LoanCovenantObligationNotificationChoice1BuilderImpl implements LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder {
	
		protected CovenantObligationIdentifier.CovenantObligationIdentifierBuilder covenantIdentifier;
		protected LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder covenantSummary;
		protected LoanCovenantObligation.LoanCovenantObligationBuilder covenant;
		
		@Override
		@RosettaAttribute("covenantIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("covenantIdentifier")
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder getCovenantIdentifier() {
			return covenantIdentifier;
		}
		
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder getOrCreateCovenantIdentifier() {
			CovenantObligationIdentifier.CovenantObligationIdentifierBuilder result;
			if (covenantIdentifier!=null) {
				result = covenantIdentifier;
			}
			else {
				result = covenantIdentifier = CovenantObligationIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("covenantSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("covenantSummary")
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder getCovenantSummary() {
			return covenantSummary;
		}
		
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder getOrCreateCovenantSummary() {
			LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder result;
			if (covenantSummary!=null) {
				result = covenantSummary;
			}
			else {
				result = covenantSummary = LoanCovenantObligationSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("covenant")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("covenant")
		public LoanCovenantObligation.LoanCovenantObligationBuilder getCovenant() {
			return covenant;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder getOrCreateCovenant() {
			LoanCovenantObligation.LoanCovenantObligationBuilder result;
			if (covenant!=null) {
				result = covenant;
			}
			else {
				result = covenant = LoanCovenantObligation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("covenantIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("covenantIdentifier")
		@Override
		public LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder setCovenantIdentifier(CovenantObligationIdentifier _covenantIdentifier) {
			this.covenantIdentifier = _covenantIdentifier == null ? null : _covenantIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("covenantSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("covenantSummary")
		@Override
		public LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder setCovenantSummary(LoanCovenantObligationSummary _covenantSummary) {
			this.covenantSummary = _covenantSummary == null ? null : _covenantSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("covenant")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("covenant")
		@Override
		public LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder setCovenant(LoanCovenantObligation _covenant) {
			this.covenant = _covenant == null ? null : _covenant.toBuilder();
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice1 build() {
			return new LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Impl(this);
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder prune() {
			if (covenantIdentifier!=null && !covenantIdentifier.prune().hasData()) covenantIdentifier = null;
			if (covenantSummary!=null && !covenantSummary.prune().hasData()) covenantSummary = null;
			if (covenant!=null && !covenant.prune().hasData()) covenant = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCovenantIdentifier()!=null && getCovenantIdentifier().hasData()) return true;
			if (getCovenantSummary()!=null && getCovenantSummary().hasData()) return true;
			if (getCovenant()!=null && getCovenant().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder o = (LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder) other;
			
			merger.mergeRosetta(getCovenantIdentifier(), o.getCovenantIdentifier(), this::setCovenantIdentifier);
			merger.mergeRosetta(getCovenantSummary(), o.getCovenantSummary(), this::setCovenantSummary);
			merger.mergeRosetta(getCovenant(), o.getCovenant(), this::setCovenant);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationNotificationChoice1 _that = getType().cast(o);
		
			if (!Objects.equals(covenantIdentifier, _that.getCovenantIdentifier())) return false;
			if (!Objects.equals(covenantSummary, _that.getCovenantSummary())) return false;
			if (!Objects.equals(covenant, _that.getCovenant())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (covenantIdentifier != null ? covenantIdentifier.hashCode() : 0);
			_result = 31 * _result + (covenantSummary != null ? covenantSummary.hashCode() : 0);
			_result = 31 * _result + (covenant != null ? covenant.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationNotificationChoice1Builder {" +
				"covenantIdentifier=" + this.covenantIdentifier + ", " +
				"covenantSummary=" + this.covenantSummary + ", " +
				"covenant=" + this.covenant +
			'}';
		}
	}
}
