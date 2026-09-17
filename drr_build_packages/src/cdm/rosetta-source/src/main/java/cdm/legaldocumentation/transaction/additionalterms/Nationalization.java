package cdm.legaldocumentation.transaction.additionalterms;

import cdm.base.staticdata.party.AncillaryEntity;
import cdm.legaldocumentation.transaction.additionalterms.meta.NationalizationMeta;
import cdm.observable.asset.ValuationPostponement;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * section "5.1.(d).(ix)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="Nationalization", builder=Nationalization.NationalizationBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Nationalization", model="cdm", builder=Nationalization.NationalizationBuilderImpl.class, version="6.23.0")
public interface Nationalization extends RosettaModelObject {

	NationalizationMeta metaData = new NationalizationMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getNationalizationIsApplicable();
	List<? extends AncillaryEntity> getRelevantAffiliate();
	EscrowArrangement getEscrowArrangement();
	Boolean getAssignmentOfClaim();
	ValuationPostponement getMaximumDaysOfDisruption();

	/*********************** Build Methods  ***********************/
	Nationalization build();
	
	Nationalization.NationalizationBuilder toBuilder();
	
	static Nationalization.NationalizationBuilder builder() {
		return new Nationalization.NationalizationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Nationalization> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Nationalization> getType() {
		return Nationalization.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nationalizationIsApplicable"), Boolean.class, getNationalizationIsApplicable(), this);
		processRosetta(path.newSubPath("relevantAffiliate"), processor, AncillaryEntity.class, getRelevantAffiliate());
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
		processor.processBasic(path.newSubPath("assignmentOfClaim"), Boolean.class, getAssignmentOfClaim(), this);
		processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.class, getMaximumDaysOfDisruption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NationalizationBuilder extends Nationalization, RosettaModelObjectBuilder {
		AncillaryEntity.AncillaryEntityBuilder getOrCreateRelevantAffiliate(int index);
		@Override
		List<? extends AncillaryEntity.AncillaryEntityBuilder> getRelevantAffiliate();
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		ValuationPostponement.ValuationPostponementBuilder getOrCreateMaximumDaysOfDisruption();
		@Override
		ValuationPostponement.ValuationPostponementBuilder getMaximumDaysOfDisruption();
		Nationalization.NationalizationBuilder setNationalizationIsApplicable(Boolean nationalizationIsApplicable);
		Nationalization.NationalizationBuilder addRelevantAffiliate(AncillaryEntity relevantAffiliate);
		Nationalization.NationalizationBuilder addRelevantAffiliate(AncillaryEntity relevantAffiliate, int idx);
		Nationalization.NationalizationBuilder addRelevantAffiliate(List<? extends AncillaryEntity> relevantAffiliate);
		Nationalization.NationalizationBuilder setRelevantAffiliate(List<? extends AncillaryEntity> relevantAffiliate);
		Nationalization.NationalizationBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);
		Nationalization.NationalizationBuilder setAssignmentOfClaim(Boolean assignmentOfClaim);
		Nationalization.NationalizationBuilder setMaximumDaysOfDisruption(ValuationPostponement maximumDaysOfDisruption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nationalizationIsApplicable"), Boolean.class, getNationalizationIsApplicable(), this);
			processRosetta(path.newSubPath("relevantAffiliate"), processor, AncillaryEntity.AncillaryEntityBuilder.class, getRelevantAffiliate());
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
			processor.processBasic(path.newSubPath("assignmentOfClaim"), Boolean.class, getAssignmentOfClaim(), this);
			processRosetta(path.newSubPath("maximumDaysOfDisruption"), processor, ValuationPostponement.ValuationPostponementBuilder.class, getMaximumDaysOfDisruption());
		}
		

		Nationalization.NationalizationBuilder prune();
	}

	/*********************** Immutable Implementation of Nationalization  ***********************/
	class NationalizationImpl implements Nationalization {
		private final Boolean nationalizationIsApplicable;
		private final List<? extends AncillaryEntity> relevantAffiliate;
		private final EscrowArrangement escrowArrangement;
		private final Boolean assignmentOfClaim;
		private final ValuationPostponement maximumDaysOfDisruption;
		
		protected NationalizationImpl(Nationalization.NationalizationBuilder builder) {
			this.nationalizationIsApplicable = builder.getNationalizationIsApplicable();
			this.relevantAffiliate = ofNullable(builder.getRelevantAffiliate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
			this.assignmentOfClaim = builder.getAssignmentOfClaim();
			this.maximumDaysOfDisruption = ofNullable(builder.getMaximumDaysOfDisruption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nationalizationIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nationalizationIsApplicable")
		public Boolean getNationalizationIsApplicable() {
			return nationalizationIsApplicable;
		}
		
		@Override
		@RosettaAttribute("relevantAffiliate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relevantAffiliate")
		public List<? extends AncillaryEntity> getRelevantAffiliate() {
			return relevantAffiliate;
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		@RosettaAttribute("assignmentOfClaim")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assignmentOfClaim")
		public Boolean getAssignmentOfClaim() {
			return assignmentOfClaim;
		}
		
		@Override
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		public ValuationPostponement getMaximumDaysOfDisruption() {
			return maximumDaysOfDisruption;
		}
		
		@Override
		public Nationalization build() {
			return this;
		}
		
		@Override
		public Nationalization.NationalizationBuilder toBuilder() {
			Nationalization.NationalizationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Nationalization.NationalizationBuilder builder) {
			ofNullable(getNationalizationIsApplicable()).ifPresent(builder::setNationalizationIsApplicable);
			ofNullable(getRelevantAffiliate()).ifPresent(builder::setRelevantAffiliate);
			ofNullable(getEscrowArrangement()).ifPresent(builder::setEscrowArrangement);
			ofNullable(getAssignmentOfClaim()).ifPresent(builder::setAssignmentOfClaim);
			ofNullable(getMaximumDaysOfDisruption()).ifPresent(builder::setMaximumDaysOfDisruption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Nationalization _that = getType().cast(o);
		
			if (!Objects.equals(nationalizationIsApplicable, _that.getNationalizationIsApplicable())) return false;
			if (!ListEquals.listEquals(relevantAffiliate, _that.getRelevantAffiliate())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			if (!Objects.equals(assignmentOfClaim, _that.getAssignmentOfClaim())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nationalizationIsApplicable != null ? nationalizationIsApplicable.hashCode() : 0);
			_result = 31 * _result + (relevantAffiliate != null ? relevantAffiliate.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			_result = 31 * _result + (assignmentOfClaim != null ? assignmentOfClaim.hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Nationalization {" +
				"nationalizationIsApplicable=" + this.nationalizationIsApplicable + ", " +
				"relevantAffiliate=" + this.relevantAffiliate + ", " +
				"escrowArrangement=" + this.escrowArrangement + ", " +
				"assignmentOfClaim=" + this.assignmentOfClaim + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption +
			'}';
		}
	}

	/*********************** Builder Implementation of Nationalization  ***********************/
	class NationalizationBuilderImpl implements Nationalization.NationalizationBuilder {
	
		protected Boolean nationalizationIsApplicable;
		protected List<AncillaryEntity.AncillaryEntityBuilder> relevantAffiliate = new ArrayList<>();
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		protected Boolean assignmentOfClaim;
		protected ValuationPostponement.ValuationPostponementBuilder maximumDaysOfDisruption;
		
		@Override
		@RosettaAttribute("nationalizationIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nationalizationIsApplicable")
		public Boolean getNationalizationIsApplicable() {
			return nationalizationIsApplicable;
		}
		
		@Override
		@RosettaAttribute("relevantAffiliate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relevantAffiliate")
		public List<? extends AncillaryEntity.AncillaryEntityBuilder> getRelevantAffiliate() {
			return relevantAffiliate;
		}
		
		@Override
		public AncillaryEntity.AncillaryEntityBuilder getOrCreateRelevantAffiliate(int index) {
			if (relevantAffiliate==null) {
				this.relevantAffiliate = new ArrayList<>();
			}
			return getIndex(relevantAffiliate, index, () -> {
						AncillaryEntity.AncillaryEntityBuilder newRelevantAffiliate = AncillaryEntity.builder();
						return newRelevantAffiliate;
					});
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		public EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement() {
			EscrowArrangement.EscrowArrangementBuilder result;
			if (escrowArrangement!=null) {
				result = escrowArrangement;
			}
			else {
				result = escrowArrangement = EscrowArrangement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assignmentOfClaim")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assignmentOfClaim")
		public Boolean getAssignmentOfClaim() {
			return assignmentOfClaim;
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
		
		@RosettaAttribute("nationalizationIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nationalizationIsApplicable")
		@Override
		public Nationalization.NationalizationBuilder setNationalizationIsApplicable(Boolean _nationalizationIsApplicable) {
			this.nationalizationIsApplicable = _nationalizationIsApplicable == null ? null : _nationalizationIsApplicable;
			return this;
		}
		
		@RosettaAttribute("relevantAffiliate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relevantAffiliate")
		@Override
		public Nationalization.NationalizationBuilder addRelevantAffiliate(AncillaryEntity _relevantAffiliate) {
			if (_relevantAffiliate != null) {
				this.relevantAffiliate.add(_relevantAffiliate.toBuilder());
			}
			return this;
		}
		
		@Override
		public Nationalization.NationalizationBuilder addRelevantAffiliate(AncillaryEntity _relevantAffiliate, int idx) {
			getIndex(this.relevantAffiliate, idx, () -> _relevantAffiliate.toBuilder());
			return this;
		}
		
		@Override
		public Nationalization.NationalizationBuilder addRelevantAffiliate(List<? extends AncillaryEntity> relevantAffiliates) {
			if (relevantAffiliates != null) {
				for (final AncillaryEntity toAdd : relevantAffiliates) {
					this.relevantAffiliate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relevantAffiliate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relevantAffiliate")
		@Override
		public Nationalization.NationalizationBuilder setRelevantAffiliate(List<? extends AncillaryEntity> relevantAffiliates) {
			if (relevantAffiliates == null) {
				this.relevantAffiliate = new ArrayList<>();
			} else {
				this.relevantAffiliate = relevantAffiliates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public Nationalization.NationalizationBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("assignmentOfClaim")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assignmentOfClaim")
		@Override
		public Nationalization.NationalizationBuilder setAssignmentOfClaim(Boolean _assignmentOfClaim) {
			this.assignmentOfClaim = _assignmentOfClaim == null ? null : _assignmentOfClaim;
			return this;
		}
		
		@RosettaAttribute("maximumDaysOfDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumDaysOfDisruption")
		@Override
		public Nationalization.NationalizationBuilder setMaximumDaysOfDisruption(ValuationPostponement _maximumDaysOfDisruption) {
			this.maximumDaysOfDisruption = _maximumDaysOfDisruption == null ? null : _maximumDaysOfDisruption.toBuilder();
			return this;
		}
		
		@Override
		public Nationalization build() {
			return new Nationalization.NationalizationImpl(this);
		}
		
		@Override
		public Nationalization.NationalizationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Nationalization.NationalizationBuilder prune() {
			relevantAffiliate = relevantAffiliate.stream().filter(b->b!=null).<AncillaryEntity.AncillaryEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			if (maximumDaysOfDisruption!=null && !maximumDaysOfDisruption.prune().hasData()) maximumDaysOfDisruption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNationalizationIsApplicable()!=null) return true;
			if (getRelevantAffiliate()!=null && getRelevantAffiliate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			if (getAssignmentOfClaim()!=null) return true;
			if (getMaximumDaysOfDisruption()!=null && getMaximumDaysOfDisruption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Nationalization.NationalizationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Nationalization.NationalizationBuilder o = (Nationalization.NationalizationBuilder) other;
			
			merger.mergeRosetta(getRelevantAffiliate(), o.getRelevantAffiliate(), this::getOrCreateRelevantAffiliate);
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			merger.mergeRosetta(getMaximumDaysOfDisruption(), o.getMaximumDaysOfDisruption(), this::setMaximumDaysOfDisruption);
			
			merger.mergeBasic(getNationalizationIsApplicable(), o.getNationalizationIsApplicable(), this::setNationalizationIsApplicable);
			merger.mergeBasic(getAssignmentOfClaim(), o.getAssignmentOfClaim(), this::setAssignmentOfClaim);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Nationalization _that = getType().cast(o);
		
			if (!Objects.equals(nationalizationIsApplicable, _that.getNationalizationIsApplicable())) return false;
			if (!ListEquals.listEquals(relevantAffiliate, _that.getRelevantAffiliate())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			if (!Objects.equals(assignmentOfClaim, _that.getAssignmentOfClaim())) return false;
			if (!Objects.equals(maximumDaysOfDisruption, _that.getMaximumDaysOfDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nationalizationIsApplicable != null ? nationalizationIsApplicable.hashCode() : 0);
			_result = 31 * _result + (relevantAffiliate != null ? relevantAffiliate.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			_result = 31 * _result + (assignmentOfClaim != null ? assignmentOfClaim.hashCode() : 0);
			_result = 31 * _result + (maximumDaysOfDisruption != null ? maximumDaysOfDisruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NationalizationBuilder {" +
				"nationalizationIsApplicable=" + this.nationalizationIsApplicable + ", " +
				"relevantAffiliate=" + this.relevantAffiliate + ", " +
				"escrowArrangement=" + this.escrowArrangement + ", " +
				"assignmentOfClaim=" + this.assignmentOfClaim + ", " +
				"maximumDaysOfDisruption=" + this.maximumDaysOfDisruption +
			'}';
		}
	}
}
