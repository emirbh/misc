package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.doc.FacilityExecutionExceptionDeclaration;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryTradingObligationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="RegulatoryTradingObligation", builder=RegulatoryTradingObligation.RegulatoryTradingObligationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryTradingObligation", model="fpml", builder=RegulatoryTradingObligation.RegulatoryTradingObligationBuilderImpl.class, version="2.1.1")
public interface RegulatoryTradingObligation extends RosettaModelObject {

	RegulatoryTradingObligationMeta metaData = new RegulatoryTradingObligationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the particular product must be executed on a SEF or DCM. See to Dodd-Frank section 723(a)(8).
	 *
	 */
	Boolean getTradedOnVenue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
	 *
	 */
	Boolean getException();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides supporting evidence when a party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
	 *
	 */
	FacilityExecutionExceptionDeclaration getExceptionDeclaration();

	/*********************** Build Methods  ***********************/
	RegulatoryTradingObligation build();
	
	RegulatoryTradingObligation.RegulatoryTradingObligationBuilder toBuilder();
	
	static RegulatoryTradingObligation.RegulatoryTradingObligationBuilder builder() {
		return new RegulatoryTradingObligation.RegulatoryTradingObligationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryTradingObligation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryTradingObligation> getType() {
		return RegulatoryTradingObligation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tradedOnVenue"), Boolean.class, getTradedOnVenue(), this);
		processor.processBasic(path.newSubPath("exception"), Boolean.class, getException(), this);
		processRosetta(path.newSubPath("exceptionDeclaration"), processor, FacilityExecutionExceptionDeclaration.class, getExceptionDeclaration());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryTradingObligationBuilder extends RegulatoryTradingObligation, RosettaModelObjectBuilder {
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getOrCreateExceptionDeclaration();
		@Override
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getExceptionDeclaration();
		RegulatoryTradingObligation.RegulatoryTradingObligationBuilder setTradedOnVenue(Boolean tradedOnVenue);
		RegulatoryTradingObligation.RegulatoryTradingObligationBuilder setException(Boolean exception);
		RegulatoryTradingObligation.RegulatoryTradingObligationBuilder setExceptionDeclaration(FacilityExecutionExceptionDeclaration exceptionDeclaration);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tradedOnVenue"), Boolean.class, getTradedOnVenue(), this);
			processor.processBasic(path.newSubPath("exception"), Boolean.class, getException(), this);
			processRosetta(path.newSubPath("exceptionDeclaration"), processor, FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder.class, getExceptionDeclaration());
		}
		

		RegulatoryTradingObligation.RegulatoryTradingObligationBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryTradingObligation  ***********************/
	class RegulatoryTradingObligationImpl implements RegulatoryTradingObligation {
		private final Boolean tradedOnVenue;
		private final Boolean exception;
		private final FacilityExecutionExceptionDeclaration exceptionDeclaration;
		
		protected RegulatoryTradingObligationImpl(RegulatoryTradingObligation.RegulatoryTradingObligationBuilder builder) {
			this.tradedOnVenue = builder.getTradedOnVenue();
			this.exception = builder.getException();
			this.exceptionDeclaration = ofNullable(builder.getExceptionDeclaration()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradedOnVenue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradedOnVenue")
		public Boolean getTradedOnVenue() {
			return tradedOnVenue;
		}
		
		@Override
		@RosettaAttribute("exception")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exception")
		public Boolean getException() {
			return exception;
		}
		
		@Override
		@RosettaAttribute("exceptionDeclaration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exceptionDeclaration")
		public FacilityExecutionExceptionDeclaration getExceptionDeclaration() {
			return exceptionDeclaration;
		}
		
		@Override
		public RegulatoryTradingObligation build() {
			return this;
		}
		
		@Override
		public RegulatoryTradingObligation.RegulatoryTradingObligationBuilder toBuilder() {
			RegulatoryTradingObligation.RegulatoryTradingObligationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryTradingObligation.RegulatoryTradingObligationBuilder builder) {
			ofNullable(getTradedOnVenue()).ifPresent(builder::setTradedOnVenue);
			ofNullable(getException()).ifPresent(builder::setException);
			ofNullable(getExceptionDeclaration()).ifPresent(builder::setExceptionDeclaration);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryTradingObligation _that = getType().cast(o);
		
			if (!Objects.equals(tradedOnVenue, _that.getTradedOnVenue())) return false;
			if (!Objects.equals(exception, _that.getException())) return false;
			if (!Objects.equals(exceptionDeclaration, _that.getExceptionDeclaration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradedOnVenue != null ? tradedOnVenue.hashCode() : 0);
			_result = 31 * _result + (exception != null ? exception.hashCode() : 0);
			_result = 31 * _result + (exceptionDeclaration != null ? exceptionDeclaration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryTradingObligation {" +
				"tradedOnVenue=" + this.tradedOnVenue + ", " +
				"exception=" + this.exception + ", " +
				"exceptionDeclaration=" + this.exceptionDeclaration +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryTradingObligation  ***********************/
	class RegulatoryTradingObligationBuilderImpl implements RegulatoryTradingObligation.RegulatoryTradingObligationBuilder {
	
		protected Boolean tradedOnVenue;
		protected Boolean exception;
		protected FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder exceptionDeclaration;
		
		@Override
		@RosettaAttribute("tradedOnVenue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradedOnVenue")
		public Boolean getTradedOnVenue() {
			return tradedOnVenue;
		}
		
		@Override
		@RosettaAttribute("exception")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exception")
		public Boolean getException() {
			return exception;
		}
		
		@Override
		@RosettaAttribute("exceptionDeclaration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exceptionDeclaration")
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getExceptionDeclaration() {
			return exceptionDeclaration;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getOrCreateExceptionDeclaration() {
			FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder result;
			if (exceptionDeclaration!=null) {
				result = exceptionDeclaration;
			}
			else {
				result = exceptionDeclaration = FacilityExecutionExceptionDeclaration.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("tradedOnVenue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradedOnVenue")
		@Override
		public RegulatoryTradingObligation.RegulatoryTradingObligationBuilder setTradedOnVenue(Boolean _tradedOnVenue) {
			this.tradedOnVenue = _tradedOnVenue == null ? null : _tradedOnVenue;
			return this;
		}
		
		@RosettaAttribute("exception")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exception")
		@Override
		public RegulatoryTradingObligation.RegulatoryTradingObligationBuilder setException(Boolean _exception) {
			this.exception = _exception == null ? null : _exception;
			return this;
		}
		
		@RosettaAttribute("exceptionDeclaration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exceptionDeclaration")
		@Override
		public RegulatoryTradingObligation.RegulatoryTradingObligationBuilder setExceptionDeclaration(FacilityExecutionExceptionDeclaration _exceptionDeclaration) {
			this.exceptionDeclaration = _exceptionDeclaration == null ? null : _exceptionDeclaration.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryTradingObligation build() {
			return new RegulatoryTradingObligation.RegulatoryTradingObligationImpl(this);
		}
		
		@Override
		public RegulatoryTradingObligation.RegulatoryTradingObligationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryTradingObligation.RegulatoryTradingObligationBuilder prune() {
			if (exceptionDeclaration!=null && !exceptionDeclaration.prune().hasData()) exceptionDeclaration = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradedOnVenue()!=null) return true;
			if (getException()!=null) return true;
			if (getExceptionDeclaration()!=null && getExceptionDeclaration().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryTradingObligation.RegulatoryTradingObligationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryTradingObligation.RegulatoryTradingObligationBuilder o = (RegulatoryTradingObligation.RegulatoryTradingObligationBuilder) other;
			
			merger.mergeRosetta(getExceptionDeclaration(), o.getExceptionDeclaration(), this::setExceptionDeclaration);
			
			merger.mergeBasic(getTradedOnVenue(), o.getTradedOnVenue(), this::setTradedOnVenue);
			merger.mergeBasic(getException(), o.getException(), this::setException);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryTradingObligation _that = getType().cast(o);
		
			if (!Objects.equals(tradedOnVenue, _that.getTradedOnVenue())) return false;
			if (!Objects.equals(exception, _that.getException())) return false;
			if (!Objects.equals(exceptionDeclaration, _that.getExceptionDeclaration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradedOnVenue != null ? tradedOnVenue.hashCode() : 0);
			_result = 31 * _result + (exception != null ? exception.hashCode() : 0);
			_result = 31 * _result + (exceptionDeclaration != null ? exceptionDeclaration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryTradingObligationBuilder {" +
				"tradedOnVenue=" + this.tradedOnVenue + ", " +
				"exception=" + this.exception + ", " +
				"exceptionDeclaration=" + this.exceptionDeclaration +
			'}';
		}
	}
}
