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
import fpml.consolidated.loan.meta.LoanLegalActionNotificationChoiceChoice0Meta;
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
@RosettaDataType(value="LoanLegalActionNotificationChoiceChoice0", builder=LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0BuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionNotificationChoiceChoice0", model="fpml", builder=LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0BuilderImpl.class, version="2.1.1")
public interface LoanLegalActionNotificationChoiceChoice0 extends RosettaModelObject {

	LoanLegalActionNotificationChoiceChoice0Meta metaData = new LoanLegalActionNotificationChoiceChoice0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A facility identifier structure.
	 *
	 */
	FacilityIdentifier getFacilityIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A facility summary structure.
	 *
	 */
	FacilitySummary getFacilitySummary();

	/*********************** Build Methods  ***********************/
	LoanLegalActionNotificationChoiceChoice0 build();
	
	LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder toBuilder();
	
	static LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder builder() {
		return new LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionNotificationChoiceChoice0> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionNotificationChoiceChoice0> getType() {
		return LoanLegalActionNotificationChoiceChoice0.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.class, getFacilitySummary());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionNotificationChoiceChoice0Builder extends LoanLegalActionNotificationChoiceChoice0, RosettaModelObjectBuilder {
		FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier();
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier();
		FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary();
		@Override
		FacilitySummary.FacilitySummaryBuilder getFacilitySummary();
		LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder setFacilitySummary(FacilitySummary facilitySummary);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.FacilitySummaryBuilder.class, getFacilitySummary());
		}
		

		LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionNotificationChoiceChoice0  ***********************/
	class LoanLegalActionNotificationChoiceChoice0Impl implements LoanLegalActionNotificationChoiceChoice0 {
		private final FacilityIdentifier facilityIdentifier;
		private final FacilitySummary facilitySummary;
		
		protected LoanLegalActionNotificationChoiceChoice0Impl(LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder builder) {
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.facilitySummary = ofNullable(builder.getFacilitySummary()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityIdentifier")
		public FacilityIdentifier getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilitySummary")
		public FacilitySummary getFacilitySummary() {
			return facilitySummary;
		}
		
		@Override
		public LoanLegalActionNotificationChoiceChoice0 build() {
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder toBuilder() {
			LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder builder) {
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilitySummary()).ifPresent(builder::setFacilitySummary);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionNotificationChoiceChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionNotificationChoiceChoice0 {" +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionNotificationChoiceChoice0  ***********************/
	class LoanLegalActionNotificationChoiceChoice0BuilderImpl implements LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder {
	
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected FacilitySummary.FacilitySummaryBuilder facilitySummary;
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityIdentifier")
		public FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier() {
			FacilityIdentifier.FacilityIdentifierBuilder result;
			if (facilityIdentifier!=null) {
				result = facilityIdentifier;
			}
			else {
				result = facilityIdentifier = FacilityIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilitySummary")
		public FacilitySummary.FacilitySummaryBuilder getFacilitySummary() {
			return facilitySummary;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary() {
			FacilitySummary.FacilitySummaryBuilder result;
			if (facilitySummary!=null) {
				result = facilitySummary;
			}
			else {
				result = facilitySummary = FacilitySummary.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityIdentifier")
		@Override
		public LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder setFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			this.facilityIdentifier = _facilityIdentifier == null ? null : _facilityIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilitySummary")
		@Override
		public LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder setFacilitySummary(FacilitySummary _facilitySummary) {
			this.facilitySummary = _facilitySummary == null ? null : _facilitySummary.toBuilder();
			return this;
		}
		
		@Override
		public LoanLegalActionNotificationChoiceChoice0 build() {
			return new LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Impl(this);
		}
		
		@Override
		public LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder prune() {
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			if (facilitySummary!=null && !facilitySummary.prune().hasData()) facilitySummary = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getFacilitySummary()!=null && getFacilitySummary().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder o = (LoanLegalActionNotificationChoiceChoice0.LoanLegalActionNotificationChoiceChoice0Builder) other;
			
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getFacilitySummary(), o.getFacilitySummary(), this::setFacilitySummary);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionNotificationChoiceChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionNotificationChoiceChoice0Builder {" +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary +
			'}';
		}
	}
}
