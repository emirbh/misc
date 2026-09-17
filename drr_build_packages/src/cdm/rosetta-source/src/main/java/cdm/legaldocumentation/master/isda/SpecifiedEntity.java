package cdm.legaldocumentation.master.isda;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.common.SpecifiedEntityTermsEnum;
import cdm.legaldocumentation.master.isda.meta.SpecifiedEntityMeta;
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
 * The party specific election of Specified Entities for the Event of Default or Termination Event specified.
 * @version 6.23.0
 */
@RosettaDataType(value="SpecifiedEntity", builder=SpecifiedEntity.SpecifiedEntityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SpecifiedEntity", model="cdm", builder=SpecifiedEntity.SpecifiedEntityBuilderImpl.class, version="6.23.0")
public interface SpecifiedEntity extends RosettaModelObject {

	SpecifiedEntityMeta metaData = new SpecifiedEntityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	Party getParty();
	/**
	 * The specified entity terms for the Event of Default or Termination Event specified.
	 */
	SpecifiedEntityTermsEnum getSpecifiedEntityTerms();
	/**
	 * The specified entities for the Event of Default or Termination Event specified.
	 */
	List<? extends LegalEntity> getSpecifiedEntity();
	/**
	 * The meaning of Material Subsidiary for the Event of Default or Termination Event specified.
	 */
	String getMaterialSubsidiaryTerms();
	/**
	 * The non standard terms for the Event of Default or Termination Event specified.
	 */
	String getOtherSpecifiedEntityTerms();

	/*********************** Build Methods  ***********************/
	SpecifiedEntity build();
	
	SpecifiedEntity.SpecifiedEntityBuilder toBuilder();
	
	static SpecifiedEntity.SpecifiedEntityBuilder builder() {
		return new SpecifiedEntity.SpecifiedEntityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpecifiedEntity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SpecifiedEntity> getType() {
		return SpecifiedEntity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processor.processBasic(path.newSubPath("specifiedEntityTerms"), SpecifiedEntityTermsEnum.class, getSpecifiedEntityTerms(), this);
		processRosetta(path.newSubPath("specifiedEntity"), processor, LegalEntity.class, getSpecifiedEntity());
		processor.processBasic(path.newSubPath("materialSubsidiaryTerms"), String.class, getMaterialSubsidiaryTerms(), this);
		processor.processBasic(path.newSubPath("otherSpecifiedEntityTerms"), String.class, getOtherSpecifiedEntityTerms(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpecifiedEntityBuilder extends SpecifiedEntity, RosettaModelObjectBuilder {
		Party.PartyBuilder getOrCreateParty();
		@Override
		Party.PartyBuilder getParty();
		LegalEntity.LegalEntityBuilder getOrCreateSpecifiedEntity(int index);
		@Override
		List<? extends LegalEntity.LegalEntityBuilder> getSpecifiedEntity();
		SpecifiedEntity.SpecifiedEntityBuilder setParty(Party party);
		SpecifiedEntity.SpecifiedEntityBuilder setSpecifiedEntityTerms(SpecifiedEntityTermsEnum specifiedEntityTerms);
		SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(LegalEntity specifiedEntity);
		SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(LegalEntity specifiedEntity, int idx);
		SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(List<? extends LegalEntity> specifiedEntity);
		SpecifiedEntity.SpecifiedEntityBuilder setSpecifiedEntity(List<? extends LegalEntity> specifiedEntity);
		SpecifiedEntity.SpecifiedEntityBuilder setMaterialSubsidiaryTerms(String materialSubsidiaryTerms);
		SpecifiedEntity.SpecifiedEntityBuilder setOtherSpecifiedEntityTerms(String otherSpecifiedEntityTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processor.processBasic(path.newSubPath("specifiedEntityTerms"), SpecifiedEntityTermsEnum.class, getSpecifiedEntityTerms(), this);
			processRosetta(path.newSubPath("specifiedEntity"), processor, LegalEntity.LegalEntityBuilder.class, getSpecifiedEntity());
			processor.processBasic(path.newSubPath("materialSubsidiaryTerms"), String.class, getMaterialSubsidiaryTerms(), this);
			processor.processBasic(path.newSubPath("otherSpecifiedEntityTerms"), String.class, getOtherSpecifiedEntityTerms(), this);
		}
		

		SpecifiedEntity.SpecifiedEntityBuilder prune();
	}

	/*********************** Immutable Implementation of SpecifiedEntity  ***********************/
	class SpecifiedEntityImpl implements SpecifiedEntity {
		private final Party party;
		private final SpecifiedEntityTermsEnum specifiedEntityTerms;
		private final List<? extends LegalEntity> specifiedEntity;
		private final String materialSubsidiaryTerms;
		private final String otherSpecifiedEntityTerms;
		
		protected SpecifiedEntityImpl(SpecifiedEntity.SpecifiedEntityBuilder builder) {
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
			this.specifiedEntityTerms = builder.getSpecifiedEntityTerms();
			this.specifiedEntity = ofNullable(builder.getSpecifiedEntity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.materialSubsidiaryTerms = builder.getMaterialSubsidiaryTerms();
			this.otherSpecifiedEntityTerms = builder.getOtherSpecifiedEntityTerms();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public Party getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("specifiedEntityTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("specifiedEntityTerms")
		public SpecifiedEntityTermsEnum getSpecifiedEntityTerms() {
			return specifiedEntityTerms;
		}
		
		@Override
		@RosettaAttribute("specifiedEntity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedEntity")
		public List<? extends LegalEntity> getSpecifiedEntity() {
			return specifiedEntity;
		}
		
		@Override
		@RosettaAttribute("materialSubsidiaryTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("materialSubsidiaryTerms")
		public String getMaterialSubsidiaryTerms() {
			return materialSubsidiaryTerms;
		}
		
		@Override
		@RosettaAttribute("otherSpecifiedEntityTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherSpecifiedEntityTerms")
		public String getOtherSpecifiedEntityTerms() {
			return otherSpecifiedEntityTerms;
		}
		
		@Override
		public SpecifiedEntity build() {
			return this;
		}
		
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder toBuilder() {
			SpecifiedEntity.SpecifiedEntityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpecifiedEntity.SpecifiedEntityBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getSpecifiedEntityTerms()).ifPresent(builder::setSpecifiedEntityTerms);
			ofNullable(getSpecifiedEntity()).ifPresent(builder::setSpecifiedEntity);
			ofNullable(getMaterialSubsidiaryTerms()).ifPresent(builder::setMaterialSubsidiaryTerms);
			ofNullable(getOtherSpecifiedEntityTerms()).ifPresent(builder::setOtherSpecifiedEntityTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedEntity _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(specifiedEntityTerms, _that.getSpecifiedEntityTerms())) return false;
			if (!ListEquals.listEquals(specifiedEntity, _that.getSpecifiedEntity())) return false;
			if (!Objects.equals(materialSubsidiaryTerms, _that.getMaterialSubsidiaryTerms())) return false;
			if (!Objects.equals(otherSpecifiedEntityTerms, _that.getOtherSpecifiedEntityTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (specifiedEntityTerms != null ? specifiedEntityTerms.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specifiedEntity != null ? specifiedEntity.hashCode() : 0);
			_result = 31 * _result + (materialSubsidiaryTerms != null ? materialSubsidiaryTerms.hashCode() : 0);
			_result = 31 * _result + (otherSpecifiedEntityTerms != null ? otherSpecifiedEntityTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedEntity {" +
				"party=" + this.party + ", " +
				"specifiedEntityTerms=" + this.specifiedEntityTerms + ", " +
				"specifiedEntity=" + this.specifiedEntity + ", " +
				"materialSubsidiaryTerms=" + this.materialSubsidiaryTerms + ", " +
				"otherSpecifiedEntityTerms=" + this.otherSpecifiedEntityTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of SpecifiedEntity  ***********************/
	class SpecifiedEntityBuilderImpl implements SpecifiedEntity.SpecifiedEntityBuilder {
	
		protected Party.PartyBuilder party;
		protected SpecifiedEntityTermsEnum specifiedEntityTerms;
		protected List<LegalEntity.LegalEntityBuilder> specifiedEntity = new ArrayList<>();
		protected String materialSubsidiaryTerms;
		protected String otherSpecifiedEntityTerms;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("specifiedEntityTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("specifiedEntityTerms")
		public SpecifiedEntityTermsEnum getSpecifiedEntityTerms() {
			return specifiedEntityTerms;
		}
		
		@Override
		@RosettaAttribute("specifiedEntity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedEntity")
		public List<? extends LegalEntity.LegalEntityBuilder> getSpecifiedEntity() {
			return specifiedEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateSpecifiedEntity(int index) {
			if (specifiedEntity==null) {
				this.specifiedEntity = new ArrayList<>();
			}
			return getIndex(specifiedEntity, index, () -> {
						LegalEntity.LegalEntityBuilder newSpecifiedEntity = LegalEntity.builder();
						return newSpecifiedEntity;
					});
		}
		
		@Override
		@RosettaAttribute("materialSubsidiaryTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("materialSubsidiaryTerms")
		public String getMaterialSubsidiaryTerms() {
			return materialSubsidiaryTerms;
		}
		
		@Override
		@RosettaAttribute("otherSpecifiedEntityTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherSpecifiedEntityTerms")
		public String getOtherSpecifiedEntityTerms() {
			return otherSpecifiedEntityTerms;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder setParty(Party _party) {
			this.party = _party == null ? null : _party.toBuilder();
			return this;
		}
		
		@RosettaAttribute("specifiedEntityTerms")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("specifiedEntityTerms")
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder setSpecifiedEntityTerms(SpecifiedEntityTermsEnum _specifiedEntityTerms) {
			this.specifiedEntityTerms = _specifiedEntityTerms == null ? null : _specifiedEntityTerms;
			return this;
		}
		
		@RosettaAttribute("specifiedEntity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("specifiedEntity")
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(LegalEntity _specifiedEntity) {
			if (_specifiedEntity != null) {
				this.specifiedEntity.add(_specifiedEntity.toBuilder());
			}
			return this;
		}
		
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(LegalEntity _specifiedEntity, int idx) {
			getIndex(this.specifiedEntity, idx, () -> _specifiedEntity.toBuilder());
			return this;
		}
		
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder addSpecifiedEntity(List<? extends LegalEntity> specifiedEntitys) {
			if (specifiedEntitys != null) {
				for (final LegalEntity toAdd : specifiedEntitys) {
					this.specifiedEntity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("specifiedEntity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("specifiedEntity")
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder setSpecifiedEntity(List<? extends LegalEntity> specifiedEntitys) {
			if (specifiedEntitys == null) {
				this.specifiedEntity = new ArrayList<>();
			} else {
				this.specifiedEntity = specifiedEntitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("materialSubsidiaryTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("materialSubsidiaryTerms")
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder setMaterialSubsidiaryTerms(String _materialSubsidiaryTerms) {
			this.materialSubsidiaryTerms = _materialSubsidiaryTerms == null ? null : _materialSubsidiaryTerms;
			return this;
		}
		
		@RosettaAttribute("otherSpecifiedEntityTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherSpecifiedEntityTerms")
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder setOtherSpecifiedEntityTerms(String _otherSpecifiedEntityTerms) {
			this.otherSpecifiedEntityTerms = _otherSpecifiedEntityTerms == null ? null : _otherSpecifiedEntityTerms;
			return this;
		}
		
		@Override
		public SpecifiedEntity build() {
			return new SpecifiedEntity.SpecifiedEntityImpl(this);
		}
		
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder prune() {
			if (party!=null && !party.prune().hasData()) party = null;
			specifiedEntity = specifiedEntity.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null && getParty().hasData()) return true;
			if (getSpecifiedEntityTerms()!=null) return true;
			if (getSpecifiedEntity()!=null && getSpecifiedEntity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMaterialSubsidiaryTerms()!=null) return true;
			if (getOtherSpecifiedEntityTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedEntity.SpecifiedEntityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SpecifiedEntity.SpecifiedEntityBuilder o = (SpecifiedEntity.SpecifiedEntityBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			merger.mergeRosetta(getSpecifiedEntity(), o.getSpecifiedEntity(), this::getOrCreateSpecifiedEntity);
			
			merger.mergeBasic(getSpecifiedEntityTerms(), o.getSpecifiedEntityTerms(), this::setSpecifiedEntityTerms);
			merger.mergeBasic(getMaterialSubsidiaryTerms(), o.getMaterialSubsidiaryTerms(), this::setMaterialSubsidiaryTerms);
			merger.mergeBasic(getOtherSpecifiedEntityTerms(), o.getOtherSpecifiedEntityTerms(), this::setOtherSpecifiedEntityTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedEntity _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(specifiedEntityTerms, _that.getSpecifiedEntityTerms())) return false;
			if (!ListEquals.listEquals(specifiedEntity, _that.getSpecifiedEntity())) return false;
			if (!Objects.equals(materialSubsidiaryTerms, _that.getMaterialSubsidiaryTerms())) return false;
			if (!Objects.equals(otherSpecifiedEntityTerms, _that.getOtherSpecifiedEntityTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (specifiedEntityTerms != null ? specifiedEntityTerms.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (specifiedEntity != null ? specifiedEntity.hashCode() : 0);
			_result = 31 * _result + (materialSubsidiaryTerms != null ? materialSubsidiaryTerms.hashCode() : 0);
			_result = 31 * _result + (otherSpecifiedEntityTerms != null ? otherSpecifiedEntityTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedEntityBuilder {" +
				"party=" + this.party + ", " +
				"specifiedEntityTerms=" + this.specifiedEntityTerms + ", " +
				"specifiedEntity=" + this.specifiedEntity + ", " +
				"materialSubsidiaryTerms=" + this.materialSubsidiaryTerms + ", " +
				"otherSpecifiedEntityTerms=" + this.otherSpecifiedEntityTerms +
			'}';
		}
	}
}
