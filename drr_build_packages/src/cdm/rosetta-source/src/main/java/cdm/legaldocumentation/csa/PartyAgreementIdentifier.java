package cdm.legaldocumentation.csa;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.legaldocumentation.csa.meta.PartyAgreementIdentifierMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
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
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class defining a legal agreement identifier issued by the indicated party.
 * @version 6.23.0
 */
@RosettaDataType(value="PartyAgreementIdentifier", builder=PartyAgreementIdentifier.PartyAgreementIdentifierBuilderImpl.class, version="6.23.0")
@RuneDataType(value="PartyAgreementIdentifier", model="cdm", builder=PartyAgreementIdentifier.PartyAgreementIdentifierBuilderImpl.class, version="6.23.0")
public interface PartyAgreementIdentifier extends RosettaModelObject, GlobalKey {

	PartyAgreementIdentifierMeta metaData = new PartyAgreementIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Party that issued the document identifier.
	 */
	ReferenceWithMetaParty getPartyReference();
	/**
	 * While FpML specifies the document identifier with a value and an associated scheme, the CDM makes use of the Identifier, which has an explicit issuer. The issuer of this identifier is not necessarily the same as the party reference.
	 */
	List<? extends FieldWithMetaIdentifier> getDocumentIdentifier();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	PartyAgreementIdentifier build();
	
	PartyAgreementIdentifier.PartyAgreementIdentifierBuilder toBuilder();
	
	static PartyAgreementIdentifier.PartyAgreementIdentifierBuilder builder() {
		return new PartyAgreementIdentifier.PartyAgreementIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyAgreementIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyAgreementIdentifier> getType() {
		return PartyAgreementIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.class, getPartyReference());
		processRosetta(path.newSubPath("documentIdentifier"), processor, FieldWithMetaIdentifier.class, getDocumentIdentifier());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyAgreementIdentifierBuilder extends PartyAgreementIdentifier, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreatePartyReference();
		@Override
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getPartyReference();
		FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder getOrCreateDocumentIdentifier(int index);
		@Override
		List<? extends FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder> getDocumentIdentifier();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setPartyReference(ReferenceWithMetaParty partyReference);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setPartyReferenceValue(Party partyReference);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(FieldWithMetaIdentifier documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(FieldWithMetaIdentifier documentIdentifier, int idx);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(Identifier documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(Identifier documentIdentifier, int idx);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(List<? extends FieldWithMetaIdentifier> documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setDocumentIdentifier(List<? extends FieldWithMetaIdentifier> documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(List<? extends Identifier> documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setDocumentIdentifierValue(List<? extends Identifier> documentIdentifier);
		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("documentIdentifier"), processor, FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder.class, getDocumentIdentifier());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		PartyAgreementIdentifier.PartyAgreementIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of PartyAgreementIdentifier  ***********************/
	class PartyAgreementIdentifierImpl implements PartyAgreementIdentifier {
		private final ReferenceWithMetaParty partyReference;
		private final List<? extends FieldWithMetaIdentifier> documentIdentifier;
		private final MetaFields meta;
		
		protected PartyAgreementIdentifierImpl(PartyAgreementIdentifier.PartyAgreementIdentifierBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.documentIdentifier = ofNullable(builder.getDocumentIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("documentIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("documentIdentifier")
		public List<? extends FieldWithMetaIdentifier> getDocumentIdentifier() {
			return documentIdentifier;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PartyAgreementIdentifier build() {
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder toBuilder() {
			PartyAgreementIdentifier.PartyAgreementIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyAgreementIdentifier.PartyAgreementIdentifierBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getDocumentIdentifier()).ifPresent(builder::setDocumentIdentifier);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyAgreementIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(documentIdentifier, _that.getDocumentIdentifier())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (documentIdentifier != null ? documentIdentifier.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyAgreementIdentifier {" +
				"partyReference=" + this.partyReference + ", " +
				"documentIdentifier=" + this.documentIdentifier + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyAgreementIdentifier  ***********************/
	class PartyAgreementIdentifierBuilderImpl implements PartyAgreementIdentifier.PartyAgreementIdentifierBuilder {
	
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference;
		protected List<FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder> documentIdentifier = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		
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
		@RosettaAttribute("documentIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("documentIdentifier")
		public List<? extends FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder> getDocumentIdentifier() {
			return documentIdentifier;
		}
		
		@Override
		public FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder getOrCreateDocumentIdentifier(int index) {
			if (documentIdentifier==null) {
				this.documentIdentifier = new ArrayList<>();
			}
			return getIndex(documentIdentifier, index, () -> {
						FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder newDocumentIdentifier = FieldWithMetaIdentifier.builder();
						return newDocumentIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setPartyReference(ReferenceWithMetaParty _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setPartyReferenceValue(Party _partyReference) {
			this.getOrCreatePartyReference().setValue(_partyReference);
			return this;
		}
		
		@RosettaAttribute("documentIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("documentIdentifier")
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(FieldWithMetaIdentifier _documentIdentifier) {
			if (_documentIdentifier != null) {
				this.documentIdentifier.add(_documentIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(FieldWithMetaIdentifier _documentIdentifier, int idx) {
			getIndex(this.documentIdentifier, idx, () -> _documentIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(Identifier _documentIdentifier) {
			this.getOrCreateDocumentIdentifier(-1).setValue(_documentIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(Identifier _documentIdentifier, int idx) {
			this.getOrCreateDocumentIdentifier(idx).setValue(_documentIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifier(List<? extends FieldWithMetaIdentifier> documentIdentifiers) {
			if (documentIdentifiers != null) {
				for (final FieldWithMetaIdentifier toAdd : documentIdentifiers) {
					this.documentIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("documentIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("documentIdentifier")
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setDocumentIdentifier(List<? extends FieldWithMetaIdentifier> documentIdentifiers) {
			if (documentIdentifiers == null) {
				this.documentIdentifier = new ArrayList<>();
			} else {
				this.documentIdentifier = documentIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder addDocumentIdentifierValue(List<? extends Identifier> documentIdentifiers) {
			if (documentIdentifiers != null) {
				for (final Identifier toAdd : documentIdentifiers) {
					this.addDocumentIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setDocumentIdentifierValue(List<? extends Identifier> documentIdentifiers) {
			this.documentIdentifier.clear();
			if (documentIdentifiers != null) {
				documentIdentifiers.forEach(this::addDocumentIdentifierValue);
			}
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public PartyAgreementIdentifier build() {
			return new PartyAgreementIdentifier.PartyAgreementIdentifierImpl(this);
		}
		
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			documentIdentifier = documentIdentifier.stream().filter(b->b!=null).<FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getDocumentIdentifier()!=null && getDocumentIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyAgreementIdentifier.PartyAgreementIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyAgreementIdentifier.PartyAgreementIdentifierBuilder o = (PartyAgreementIdentifier.PartyAgreementIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getDocumentIdentifier(), o.getDocumentIdentifier(), this::getOrCreateDocumentIdentifier);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyAgreementIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(documentIdentifier, _that.getDocumentIdentifier())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (documentIdentifier != null ? documentIdentifier.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyAgreementIdentifierBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"documentIdentifier=" + this.documentIdentifier + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
