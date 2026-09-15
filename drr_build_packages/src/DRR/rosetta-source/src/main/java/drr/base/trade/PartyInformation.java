package drr.base.trade;

import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
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
import drr.base.trade.meta.PartyInformationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies party specific information required for reporting of the transaction.
 * @version 7.7.0
 */
@RosettaDataType(value="PartyInformation", builder=PartyInformation.PartyInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="PartyInformation", model="drr", builder=PartyInformation.PartyInformationBuilderImpl.class, version="7.7.0")
public interface PartyInformation extends RosettaModelObject {

	PartyInformationMeta metaData = new PartyInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the party that is associated with the enriched information.
	 */
	ReferenceWithMetaParty getPartyReference();
	/**
	 * The role(s) that natural person(s) may have in relation to the transaction.
	 */
	List<? extends NaturalPersonRole> getRelatedPerson();
	/**
	 * Specifies one or more parties that perform a role within the transaction. The related party performs the role with respect to the party identified by the &#39;partyReference&#39;.
	 */
	List<? extends RelatedParty> getRelatedParty();

	/*********************** Build Methods  ***********************/
	PartyInformation build();
	
	PartyInformation.PartyInformationBuilder toBuilder();
	
	static PartyInformation.PartyInformationBuilder builder() {
		return new PartyInformation.PartyInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyInformation> getType() {
		return PartyInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
		processRosetta(path.newSubPath("relatedPerson"), processor, NaturalPersonRole.class, getRelatedPerson());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyInformationBuilder extends PartyInformation, RosettaModelObjectBuilder {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPartyReference();
		NaturalPersonRole.NaturalPersonRoleBuilder getOrCreateRelatedPerson(int index);
		@Override
		List<? extends NaturalPersonRole.NaturalPersonRoleBuilder> getRelatedPerson();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		PartyInformation.PartyInformationBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		PartyInformation.PartyInformationBuilder setPartyReferenceValue(Party partyReference);
		PartyInformation.PartyInformationBuilder addRelatedPerson(NaturalPersonRole relatedPerson);
		PartyInformation.PartyInformationBuilder addRelatedPerson(NaturalPersonRole relatedPerson, int idx);
		PartyInformation.PartyInformationBuilder addRelatedPerson(List<? extends NaturalPersonRole> relatedPerson);
		PartyInformation.PartyInformationBuilder setRelatedPerson(List<? extends NaturalPersonRole> relatedPerson);
		PartyInformation.PartyInformationBuilder addRelatedParty(RelatedParty relatedParty);
		PartyInformation.PartyInformationBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		PartyInformation.PartyInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		PartyInformation.PartyInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("relatedPerson"), processor, NaturalPersonRole.NaturalPersonRoleBuilder.class, getRelatedPerson());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
		}
		

		PartyInformation.PartyInformationBuilder prune();
	}

	/*********************** Immutable Implementation of PartyInformation  ***********************/
	class PartyInformationImpl implements PartyInformation {
		private final ReferenceWithMetaParty partyReference;
		private final List<? extends NaturalPersonRole> relatedPerson;
		private final List<? extends RelatedParty> relatedParty;
		
		protected PartyInformationImpl(PartyInformation.PartyInformationBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.relatedPerson = ofNullable(builder.getRelatedPerson()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public ReferenceWithMetaParty getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedPerson")
		public List<? extends NaturalPersonRole> getRelatedPerson() {
			return relatedPerson;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public PartyInformation build() {
			return this;
		}
		
		@Override
		public PartyInformation.PartyInformationBuilder toBuilder() {
			PartyInformation.PartyInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyInformation.PartyInformationBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getRelatedPerson()).ifPresent(builder::setRelatedPerson);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (relatedPerson != null ? relatedPerson.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyInformation {" +
				"partyReference=" + this.partyReference + ", " +
				"relatedPerson=" + this.relatedPerson + ", " +
				"relatedParty=" + this.relatedParty +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyInformation  ***********************/
	class PartyInformationBuilderImpl implements PartyInformation.PartyInformationBuilder {
	
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference;
		protected List<NaturalPersonRole.NaturalPersonRoleBuilder> relatedPerson = new ArrayList<>();
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyReference() {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = ReferenceWithMetaParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedPerson")
		public List<? extends NaturalPersonRole.NaturalPersonRoleBuilder> getRelatedPerson() {
			return relatedPerson;
		}
		
		@Override
		public NaturalPersonRole.NaturalPersonRoleBuilder getOrCreateRelatedPerson(int index) {
			if (relatedPerson==null) {
				this.relatedPerson = new ArrayList<>();
			}
			return getIndex(relatedPerson, index, () -> {
						NaturalPersonRole.NaturalPersonRoleBuilder newRelatedPerson = NaturalPersonRole.builder();
						return newRelatedPerson;
					});
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public PartyInformation.PartyInformationBuilder setPartyReference(ReferenceWithMetaParty _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyInformation.PartyInformationBuilder setPartyReferenceValue(Party _partyReference) {
			this.getOrCreatePartyReference().setValue(_partyReference);
			return this;
		}
		
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedPerson")
		@Override
		public PartyInformation.PartyInformationBuilder addRelatedPerson(NaturalPersonRole _relatedPerson) {
			if (_relatedPerson != null) {
				this.relatedPerson.add(_relatedPerson.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyInformation.PartyInformationBuilder addRelatedPerson(NaturalPersonRole _relatedPerson, int idx) {
			getIndex(this.relatedPerson, idx, () -> _relatedPerson.toBuilder());
			return this;
		}
		
		@Override
		public PartyInformation.PartyInformationBuilder addRelatedPerson(List<? extends NaturalPersonRole> relatedPersons) {
			if (relatedPersons != null) {
				for (final NaturalPersonRole toAdd : relatedPersons) {
					this.relatedPerson.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedPerson")
		@Override
		public PartyInformation.PartyInformationBuilder setRelatedPerson(List<? extends NaturalPersonRole> relatedPersons) {
			if (relatedPersons == null) {
				this.relatedPerson = new ArrayList<>();
			} else {
				this.relatedPerson = relatedPersons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public PartyInformation.PartyInformationBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyInformation.PartyInformationBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public PartyInformation.PartyInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public PartyInformation.PartyInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyInformation build() {
			return new PartyInformation.PartyInformationImpl(this);
		}
		
		@Override
		public PartyInformation.PartyInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyInformation.PartyInformationBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			relatedPerson = relatedPerson.stream().filter(b->b!=null).<NaturalPersonRole.NaturalPersonRoleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getRelatedPerson()!=null && getRelatedPerson().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyInformation.PartyInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyInformation.PartyInformationBuilder o = (PartyInformation.PartyInformationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getRelatedPerson(), o.getRelatedPerson(), this::getOrCreateRelatedPerson);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (relatedPerson != null ? relatedPerson.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyInformationBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"relatedPerson=" + this.relatedPerson + ", " +
				"relatedParty=" + this.relatedParty +
			'}';
		}
	}
}
