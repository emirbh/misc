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
import fpml.consolidated.loan.meta.LoanLegalActionStatementChoice0Meta;
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
@RosettaDataType(value="LoanLegalActionStatementChoice0", builder=LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0BuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionStatementChoice0", model="fpml", builder=LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0BuilderImpl.class, version="2.1.1")
public interface LoanLegalActionStatementChoice0 extends RosettaModelObject {

	LoanLegalActionStatementChoice0Meta metaData = new LoanLegalActionStatementChoice0Meta();

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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	AbstractFacility getFacilityGroup();

	/*********************** Build Methods  ***********************/
	LoanLegalActionStatementChoice0 build();
	
	LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder toBuilder();
	
	static LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder builder() {
		return new LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionStatementChoice0> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionStatementChoice0> getType() {
		return LoanLegalActionStatementChoice0.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.class, getFacilitySummary());
		processRosetta(path.newSubPath("facilityGroup"), processor, AbstractFacility.class, getFacilityGroup());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionStatementChoice0Builder extends LoanLegalActionStatementChoice0, RosettaModelObjectBuilder {
		FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier();
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier();
		FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary();
		@Override
		FacilitySummary.FacilitySummaryBuilder getFacilitySummary();
		AbstractFacility.AbstractFacilityBuilder getOrCreateFacilityGroup();
		@Override
		AbstractFacility.AbstractFacilityBuilder getFacilityGroup();
		LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder setFacilitySummary(FacilitySummary facilitySummary);
		LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder setFacilityGroup(AbstractFacility facilityGroup);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.FacilitySummaryBuilder.class, getFacilitySummary());
			processRosetta(path.newSubPath("facilityGroup"), processor, AbstractFacility.AbstractFacilityBuilder.class, getFacilityGroup());
		}
		

		LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionStatementChoice0  ***********************/
	class LoanLegalActionStatementChoice0Impl implements LoanLegalActionStatementChoice0 {
		private final FacilityIdentifier facilityIdentifier;
		private final FacilitySummary facilitySummary;
		private final AbstractFacility facilityGroup;
		
		protected LoanLegalActionStatementChoice0Impl(LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder builder) {
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.facilitySummary = ofNullable(builder.getFacilitySummary()).map(f->f.build()).orElse(null);
			this.facilityGroup = ofNullable(builder.getFacilityGroup()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("facilityGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityGroup")
		public AbstractFacility getFacilityGroup() {
			return facilityGroup;
		}
		
		@Override
		public LoanLegalActionStatementChoice0 build() {
			return this;
		}
		
		@Override
		public LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder toBuilder() {
			LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder builder) {
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilitySummary()).ifPresent(builder::setFacilitySummary);
			ofNullable(getFacilityGroup()).ifPresent(builder::setFacilityGroup);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionStatementChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!Objects.equals(facilityGroup, _that.getFacilityGroup())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (facilityGroup != null ? facilityGroup.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionStatementChoice0 {" +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"facilityGroup=" + this.facilityGroup +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionStatementChoice0  ***********************/
	class LoanLegalActionStatementChoice0BuilderImpl implements LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder {
	
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected FacilitySummary.FacilitySummaryBuilder facilitySummary;
		protected AbstractFacility.AbstractFacilityBuilder facilityGroup;
		
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
		
		@Override
		@RosettaAttribute("facilityGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityGroup")
		public AbstractFacility.AbstractFacilityBuilder getFacilityGroup() {
			return facilityGroup;
		}
		
		@Override
		public AbstractFacility.AbstractFacilityBuilder getOrCreateFacilityGroup() {
			AbstractFacility.AbstractFacilityBuilder result;
			if (facilityGroup!=null) {
				result = facilityGroup;
			}
			else {
				result = facilityGroup = AbstractFacility.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityIdentifier")
		@Override
		public LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder setFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			this.facilityIdentifier = _facilityIdentifier == null ? null : _facilityIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilitySummary")
		@Override
		public LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder setFacilitySummary(FacilitySummary _facilitySummary) {
			this.facilitySummary = _facilitySummary == null ? null : _facilitySummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityGroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityGroup")
		@Override
		public LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder setFacilityGroup(AbstractFacility _facilityGroup) {
			this.facilityGroup = _facilityGroup == null ? null : _facilityGroup.toBuilder();
			return this;
		}
		
		@Override
		public LoanLegalActionStatementChoice0 build() {
			return new LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Impl(this);
		}
		
		@Override
		public LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder prune() {
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			if (facilitySummary!=null && !facilitySummary.prune().hasData()) facilitySummary = null;
			if (facilityGroup!=null && !facilityGroup.prune().hasData()) facilityGroup = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getFacilitySummary()!=null && getFacilitySummary().hasData()) return true;
			if (getFacilityGroup()!=null && getFacilityGroup().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder o = (LoanLegalActionStatementChoice0.LoanLegalActionStatementChoice0Builder) other;
			
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getFacilitySummary(), o.getFacilitySummary(), this::setFacilitySummary);
			merger.mergeRosetta(getFacilityGroup(), o.getFacilityGroup(), this::setFacilityGroup);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionStatementChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!Objects.equals(facilityGroup, _that.getFacilityGroup())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (facilityGroup != null ? facilityGroup.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionStatementChoice0Builder {" +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"facilityGroup=" + this.facilityGroup +
			'}';
		}
	}
}
