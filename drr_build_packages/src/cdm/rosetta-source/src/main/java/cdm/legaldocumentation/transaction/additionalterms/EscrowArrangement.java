package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.additionalterms.meta.EscrowArrangementMeta;
import cdm.observable.asset.ValuationPostponement;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Refers to the segregation deposit procedure parties may want to commmit into during the time a Disruption Event is effective
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * section "5.2.(c).(iv)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="EscrowArrangement", builder=EscrowArrangement.EscrowArrangementBuilderImpl.class, version="6.23.0")
@RuneDataType(value="EscrowArrangement", model="cdm", builder=EscrowArrangement.EscrowArrangementBuilderImpl.class, version="6.23.0")
public interface EscrowArrangement extends RosettaModelObject {

	EscrowArrangementMeta metaData = new EscrowArrangementMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getEscrowArrangementIsApplicable();
	ValuationPostponement getMaximumDaysOfDisruption();
	Clause getBespokeEscrowArrangements();

	/*********************** Build Methods  ***********************/
	EscrowArrangement build();
	
	EscrowArrangement.EscrowArrangementBuilder toBuilder();
	
	static EscrowArrangement.EscrowArrangementBuilder builder() {
		return new EscrowArrangement.EscrowArrangementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EscrowArrangement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EscrowArrangement> getType() {
		return EscrowArrangement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("escrowArrangementIsApplicable"), Boolean.class, getEscrowArrangementIsApplicable(), this);
		processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.class, getMaximumDaysOfDisruption());
		processRosetta(path.newSubPath("bespokeEscrowArrangements"), processor, Clause.class, getBespokeEscrowArrangements());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EscrowArrangementBuilder extends EscrowArrangement, RosettaModelObjectBuilder {
		ValuationPostponement.ValuationPostponementBuilder getOrCreateMaximumDaysOfDisruption();
		@Override
		ValuationPostponement.ValuationPostponementBuilder getMaximumDaysOfDisruption();
		Clause.ClauseBuilder getOrCreateBespokeEscrowArrangements();
		@Override
		Clause.ClauseBuilder getBespokeEscrowArrangements();
		EscrowArrangement.EscrowArrangementBuilder setEscrowArrangementIsApplicable(Boolean escrowArrangementIsApplicable);
		EscrowArrangement.EscrowArrangementBuilder setMaximumDaysOfDisruption(ValuationPostponement maximumDaysOfDisruption);
		EscrowArrangement.EscrowArrangementBuilder setBespokeEscrowArrangements(Clause bespokeEscrowArrangements);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("escrowArrangementIsApplicable"), Boolean.class, getEscrowArrangementIsApplicable(), this);
			processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.ValuationPostponementBuilder.class, getMaximumDaysOfDisruption());
			processRosetta(path.newSubPath("bespokeEscrowArrangements"), processor, Clause.ClauseBuilder.class, getBespokeEscrowArrangements());
		}
		

		EscrowArrangement.EscrowArrangementBuilder prune();
	}

	/*********************** Immutable Implementation of EscrowArrangement  ***********************/
	class EscrowArrangementImpl implements EscrowArrangement {
		private final Boolean escrowArrangementIsApplicable;
		private final ValuationPostponement maximumDaysOfDisruption;
		private final Clause bespokeEscrowArrangements;
		
		protected EscrowArrangementImpl(EscrowArrangement.EscrowArrangementBuilder builder) {
			this.escrowArrangementIsApplicable = builder.getEscrowArrangementIsApplicable();
			this.maximumDaysOfDisruption = ofNullable(builder.getMaximumDaysOfDisruption()).map(f->f.build()).orElse(null);
			this.bespokeEscrowArrangements = ofNullable(builder.getBespokeEscrowArrangements()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("escrowArrangementIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("escrowArrangementIsApplicable")
		public Boolean getEscrowArrangementIsApplicable() {
			return escrowArrangementIsApplicable;
		}
		
		@Override
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		public ValuationPostponement getMaximumDaysOfDisruption() {
			return maximumDaysOfDisruption;
		}
		
		@Override
		@RosettaAttribute("bespokeEscrowArrangements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeEscrowArrangements")
		public Clause getBespokeEscrowArrangements() {
			return bespokeEscrowArrangements;
		}
		
		@Override
		public EscrowArrangement build() {
			return this;
		}
		
		@Override
		public EscrowArrangement.EscrowArrangementBuilder toBuilder() {
			EscrowArrangement.EscrowArrangementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EscrowArrangement.EscrowArrangementBuilder builder) {
			ofNullable(getEscrowArrangementIsApplicable()).ifPresent(builder::setEscrowArrangementIsApplicable);
			ofNullable(getMaximumDaysOfDisruption()).ifPresent(builder::setMaximumDaysOfDisruption);
			ofNullable(getBespokeEscrowArrangements()).ifPresent(builder::setBespokeEscrowArrangements);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EscrowArrangement _that = getType().cast(o);
		
			if (!Objects.equals(escrowArrangementIsApplicable, _that.getEscrowArrangementIsApplicable())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			if (!Objects.equals(bespokeEscrowArrangements, _that.getBespokeEscrowArrangements())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (escrowArrangementIsApplicable != null ? escrowArrangementIsApplicable.hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (bespokeEscrowArrangements != null ? bespokeEscrowArrangements.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EscrowArrangement {" +
				"escrowArrangementIsApplicable=" + this.escrowArrangementIsApplicable + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption + ", " +
				"bespokeEscrowArrangements=" + this.bespokeEscrowArrangements +
			'}';
		}
	}

	/*********************** Builder Implementation of EscrowArrangement  ***********************/
	class EscrowArrangementBuilderImpl implements EscrowArrangement.EscrowArrangementBuilder {
	
		protected Boolean escrowArrangementIsApplicable;
		protected ValuationPostponement.ValuationPostponementBuilder maximumDaysOfDisruption;
		protected Clause.ClauseBuilder bespokeEscrowArrangements;
		
		@Override
		@RosettaAttribute("escrowArrangementIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("escrowArrangementIsApplicable")
		public Boolean getEscrowArrangementIsApplicable() {
			return escrowArrangementIsApplicable;
		}
		
		@Override
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		public ValuationPostponement.ValuationPostponementBuilder getMaximumDaysOfDisruption() {
			return maximumDaysOfDisruption;
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder getOrCreateMaximumDaysOfDisruption() {
			ValuationPostponement.ValuationPostponementBuilder result;
			if (maximumDaysOfDisruption!=null) {
				result = maximumDaysOfDisruption;
			}
			else {
				result = maximumDaysOfDisruption = ValuationPostponement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bespokeEscrowArrangements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeEscrowArrangements")
		public Clause.ClauseBuilder getBespokeEscrowArrangements() {
			return bespokeEscrowArrangements;
		}
		
		@Override
		public Clause.ClauseBuilder getOrCreateBespokeEscrowArrangements() {
			Clause.ClauseBuilder result;
			if (bespokeEscrowArrangements!=null) {
				result = bespokeEscrowArrangements;
			}
			else {
				result = bespokeEscrowArrangements = Clause.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("escrowArrangementIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("escrowArrangementIsApplicable")
		@Override
		public EscrowArrangement.EscrowArrangementBuilder setEscrowArrangementIsApplicable(Boolean _escrowArrangementIsApplicable) {
			this.escrowArrangementIsApplicable = _escrowArrangementIsApplicable == null ? null : _escrowArrangementIsApplicable;
			return this;
		}
		
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		@Override
		public EscrowArrangement.EscrowArrangementBuilder setMaximumDaysOfDisruption(ValuationPostponement _maximumDaysOfDisruption) {
			this.maximumDaysOfDisruption = _maximumDaysOfDisruption == null ? null : _maximumDaysOfDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("bespokeEscrowArrangements")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bespokeEscrowArrangements")
		@Override
		public EscrowArrangement.EscrowArrangementBuilder setBespokeEscrowArrangements(Clause _bespokeEscrowArrangements) {
			this.bespokeEscrowArrangements = _bespokeEscrowArrangements == null ? null : _bespokeEscrowArrangements.toBuilder();
			return this;
		}
		
		@Override
		public EscrowArrangement build() {
			return new EscrowArrangement.EscrowArrangementImpl(this);
		}
		
		@Override
		public EscrowArrangement.EscrowArrangementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EscrowArrangement.EscrowArrangementBuilder prune() {
			if (maximumDaysOfDisruption!=null && !maximumDaysOfDisruption.prune().hasData()) maximumDaysOfDisruption = null;
			if (bespokeEscrowArrangements!=null && !bespokeEscrowArrangements.prune().hasData()) bespokeEscrowArrangements = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEscrowArrangementIsApplicable()!=null) return true;
			if (getMaximumDaysOfDisruption()!=null && getMaximumDaysOfDisruption().hasData()) return true;
			if (getBespokeEscrowArrangements()!=null && getBespokeEscrowArrangements().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EscrowArrangement.EscrowArrangementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EscrowArrangement.EscrowArrangementBuilder o = (EscrowArrangement.EscrowArrangementBuilder) other;
			
			merger.mergeRosetta(getMaximumDaysOfDisruption(), o.getMaximumDaysOfDisruption(), this::setMaximumDaysOfDisruption);
			merger.mergeRosetta(getBespokeEscrowArrangements(), o.getBespokeEscrowArrangements(), this::setBespokeEscrowArrangements);
			
			merger.mergeBasic(getEscrowArrangementIsApplicable(), o.getEscrowArrangementIsApplicable(), this::setEscrowArrangementIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EscrowArrangement _that = getType().cast(o);
		
			if (!Objects.equals(escrowArrangementIsApplicable, _that.getEscrowArrangementIsApplicable())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			if (!Objects.equals(bespokeEscrowArrangements, _that.getBespokeEscrowArrangements())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (escrowArrangementIsApplicable != null ? escrowArrangementIsApplicable.hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			_result = 31 * _result + (bespokeEscrowArrangements != null ? bespokeEscrowArrangements.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EscrowArrangementBuilder {" +
				"escrowArrangementIsApplicable=" + this.escrowArrangementIsApplicable + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption + ", " +
				"bespokeEscrowArrangements=" + this.bespokeEscrowArrangements +
			'}';
		}
	}
}
