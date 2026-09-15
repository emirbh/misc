package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.msg.AddressedMessage;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.reg.fpmlreporting.shared.meta.RequestRegulatoryReportingStatusMessageMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.RelatedParty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
@RosettaDataType(value="RequestRegulatoryReportingStatusMessage", builder=RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestRegulatoryReportingStatusMessage", model="fpml", builder=RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilderImpl.class, version="2.1.1")
public interface RequestRegulatoryReportingStatusMessage extends AddressedMessage {

	RequestRegulatoryReportingStatusMessageMeta metaData = new RequestRegulatoryReportingStatusMessageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates which party (or parties) (and accounts) a trade or event is being processed for. Normally there will only be a maximum of 2 parties, but in the case of a novation there could be a transferor, transferee, remaining party, and other remaining party. Also, in the context of a trade package there could be several parties for which limit check is requested, necessitating multiple onBehalfOf elements. Except for these cases, there should be no more than two onBehalfOf references in a message.
	 *
	 */
	List<? extends OnBehalfOf> getOnBehalfOf();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision identifies the affected trade
	 *
	 */
	PartyTradeIdentifier getTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The asset class of the underlying product.
	 *
	 */
	AssetClass getPrimaryAssetClass();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The supporting party definitions.
	 *
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	RequestRegulatoryReportingStatusMessage build();
	
	RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder toBuilder();
	
	static RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder builder() {
		return new RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestRegulatoryReportingStatusMessage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestRegulatoryReportingStatusMessage> getType() {
		return RequestRegulatoryReportingStatusMessage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestRegulatoryReportingStatusMessageBuilder extends RequestRegulatoryReportingStatusMessage, AddressedMessage.AddressedMessageBuilder {
		OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf(int index);
		@Override
		List<? extends OnBehalfOf.OnBehalfOfBuilder> getOnBehalfOf();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier();
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getTradeIdentifier();
		AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass();
		@Override
		AssetClass.AssetClassBuilder getPrimaryAssetClass();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setActualBuild(Integer actualBuild);
		@Override
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setHeader(NotificationMessageHeader header);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addRelatedParty(RelatedParty relatedParty);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addParty(Party party);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addParty(Party party, int idx);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addParty(List<? extends Party> party);
		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setParty(List<? extends Party> party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder prune();
	}

	/*********************** Immutable Implementation of RequestRegulatoryReportingStatusMessage  ***********************/
	class RequestRegulatoryReportingStatusMessageImpl extends AddressedMessage.AddressedMessageImpl implements RequestRegulatoryReportingStatusMessage {
		private final List<? extends OnBehalfOf> onBehalfOf;
		private final PartyTradeIdentifier tradeIdentifier;
		private final AssetClass primaryAssetClass;
		private final List<? extends RelatedParty> relatedParty;
		private final List<? extends Party> party;
		
		protected RequestRegulatoryReportingStatusMessageImpl(RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder builder) {
			super(builder);
			this.onBehalfOf = ofNullable(builder.getOnBehalfOf()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
			this.primaryAssetClass = ofNullable(builder.getPrimaryAssetClass()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		public List<? extends OnBehalfOf> getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public PartyTradeIdentifier getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryAssetClass")
		public AssetClass getPrimaryAssetClass() {
			return primaryAssetClass;
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
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public RequestRegulatoryReportingStatusMessage build() {
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder toBuilder() {
			RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOnBehalfOf()).ifPresent(builder::setOnBehalfOf);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getPrimaryAssetClass()).ifPresent(builder::setPrimaryAssetClass);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestRegulatoryReportingStatusMessage _that = getType().cast(o);
		
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestRegulatoryReportingStatusMessage {" +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestRegulatoryReportingStatusMessage  ***********************/
	class RequestRegulatoryReportingStatusMessageBuilderImpl extends AddressedMessage.AddressedMessageBuilderImpl implements RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder {
	
		protected List<OnBehalfOf.OnBehalfOfBuilder> onBehalfOf = new ArrayList<>();
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder tradeIdentifier;
		protected AssetClass.AssetClassBuilder primaryAssetClass;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		public List<? extends OnBehalfOf.OnBehalfOfBuilder> getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf(int index) {
			if (onBehalfOf==null) {
				this.onBehalfOf = new ArrayList<>();
			}
			return getIndex(onBehalfOf, index, () -> {
						OnBehalfOf.OnBehalfOfBuilder newOnBehalfOf = OnBehalfOf.builder();
						return newOnBehalfOf;
					});
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			if (tradeIdentifier!=null) {
				result = tradeIdentifier;
			}
			else {
				result = tradeIdentifier = PartyTradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryAssetClass")
		public AssetClass.AssetClassBuilder getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		public AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass() {
			AssetClass.AssetClassBuilder result;
			if (primaryAssetClass!=null) {
				result = primaryAssetClass;
			}
			else {
				result = primaryAssetClass = AssetClass.builder();
			}
			
			return result;
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
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int index) {
			if (party==null) {
				this.party = new ArrayList<>();
			}
			return getIndex(party, index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs != null) {
				for (final OnBehalfOf toAdd : onBehalfOfs) {
					this.onBehalfOf.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeIdentifier")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("party")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatusMessage build() {
			return new RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageImpl(this);
		}
		
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder prune() {
			super.prune();
			onBehalfOf = onBehalfOf.stream().filter(b->b!=null).<OnBehalfOf.OnBehalfOfBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			if (primaryAssetClass!=null && !primaryAssetClass.prune().hasData()) primaryAssetClass = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOnBehalfOf()!=null && getOnBehalfOf().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			if (getPrimaryAssetClass()!=null && getPrimaryAssetClass().hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder o = (RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder) other;
			
			merger.mergeRosetta(getOnBehalfOf(), o.getOnBehalfOf(), this::getOrCreateOnBehalfOf);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			merger.mergeRosetta(getPrimaryAssetClass(), o.getPrimaryAssetClass(), this::setPrimaryAssetClass);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestRegulatoryReportingStatusMessage _that = getType().cast(o);
		
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestRegulatoryReportingStatusMessageBuilder {" +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
