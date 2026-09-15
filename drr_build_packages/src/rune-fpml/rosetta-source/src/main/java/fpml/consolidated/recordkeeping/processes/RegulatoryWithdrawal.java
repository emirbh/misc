package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryWithdrawalMeta;
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
 * Provision A type defining the message used to request withdrawal from one or more jurisdictions.
 *
 */
@RosettaDataType(value="RegulatoryWithdrawal", builder=RegulatoryWithdrawal.RegulatoryWithdrawalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryWithdrawal", model="fpml", builder=RegulatoryWithdrawal.RegulatoryWithdrawalBuilderImpl.class, version="2.1.1")
public interface RegulatoryWithdrawal extends AddressedMessage {

	RegulatoryWithdrawalMeta metaData = new RegulatoryWithdrawalMeta();

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
	 * Provision Indicates which regulation the trade is to withdrawn from. At least one child element must be selected.
	 *
	 */
	List<? extends InapplicableRegulation> getInapplicableRegulation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getWithdrawalReason();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates if the trade is now fully withdrawn from all regulatory reports. This can be used by a trade repository to perform a consistency check. For instance, if "fullyWithdrawn" is "true" but the TR believes that the trade is still reportable to at least one regulator, it could report an exception with the identity of that regulator. Or if "fullyWithdrawn" is false but the TR believes that the trade is no longer reportable to any regulator, the TR should report that fact.
	 *
	 */
	Boolean getFullyWithdrawn();
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
	RegulatoryWithdrawal build();
	
	RegulatoryWithdrawal.RegulatoryWithdrawalBuilder toBuilder();
	
	static RegulatoryWithdrawal.RegulatoryWithdrawalBuilder builder() {
		return new RegulatoryWithdrawal.RegulatoryWithdrawalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryWithdrawal> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryWithdrawal> getType() {
		return RegulatoryWithdrawal.class;
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
		processRosetta(path.newSubPath("inapplicableRegulation"), processor, InapplicableRegulation.class, getInapplicableRegulation());
		processor.processBasic(path.newSubPath("withdrawalReason"), String.class, getWithdrawalReason(), this);
		processor.processBasic(path.newSubPath("fullyWithdrawn"), Boolean.class, getFullyWithdrawn(), this);
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryWithdrawalBuilder extends RegulatoryWithdrawal, AddressedMessage.AddressedMessageBuilder {
		OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf(int index);
		@Override
		List<? extends OnBehalfOf.OnBehalfOfBuilder> getOnBehalfOf();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier();
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getTradeIdentifier();
		AssetClass.AssetClassBuilder getOrCreatePrimaryAssetClass();
		@Override
		AssetClass.AssetClassBuilder getPrimaryAssetClass();
		InapplicableRegulation.InapplicableRegulationBuilder getOrCreateInapplicableRegulation(int index);
		@Override
		List<? extends InapplicableRegulation.InapplicableRegulationBuilder> getInapplicableRegulation();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setActualBuild(Integer actualBuild);
		@Override
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setHeader(NotificationMessageHeader header);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addInapplicableRegulation(InapplicableRegulation inapplicableRegulation);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addInapplicableRegulation(InapplicableRegulation inapplicableRegulation, int idx);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addInapplicableRegulation(List<? extends InapplicableRegulation> inapplicableRegulation);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setInapplicableRegulation(List<? extends InapplicableRegulation> inapplicableRegulation);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setWithdrawalReason(String withdrawalReason);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setFullyWithdrawn(Boolean fullyWithdrawn);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addRelatedParty(RelatedParty relatedParty);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addParty(Party party);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addParty(Party party, int idx);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addParty(List<? extends Party> party);
		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setParty(List<? extends Party> party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("inapplicableRegulation"), processor, InapplicableRegulation.InapplicableRegulationBuilder.class, getInapplicableRegulation());
			processor.processBasic(path.newSubPath("withdrawalReason"), String.class, getWithdrawalReason(), this);
			processor.processBasic(path.newSubPath("fullyWithdrawn"), Boolean.class, getFullyWithdrawn(), this);
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		RegulatoryWithdrawal.RegulatoryWithdrawalBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryWithdrawal  ***********************/
	class RegulatoryWithdrawalImpl extends AddressedMessage.AddressedMessageImpl implements RegulatoryWithdrawal {
		private final List<? extends OnBehalfOf> onBehalfOf;
		private final PartyTradeIdentifier tradeIdentifier;
		private final AssetClass primaryAssetClass;
		private final List<? extends InapplicableRegulation> inapplicableRegulation;
		private final String withdrawalReason;
		private final Boolean fullyWithdrawn;
		private final List<? extends RelatedParty> relatedParty;
		private final List<? extends Party> party;
		
		protected RegulatoryWithdrawalImpl(RegulatoryWithdrawal.RegulatoryWithdrawalBuilder builder) {
			super(builder);
			this.onBehalfOf = ofNullable(builder.getOnBehalfOf()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
			this.primaryAssetClass = ofNullable(builder.getPrimaryAssetClass()).map(f->f.build()).orElse(null);
			this.inapplicableRegulation = ofNullable(builder.getInapplicableRegulation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.withdrawalReason = builder.getWithdrawalReason();
			this.fullyWithdrawn = builder.getFullyWithdrawn();
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
		@RosettaAttribute("inapplicableRegulation")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("inapplicableRegulation")
		public List<? extends InapplicableRegulation> getInapplicableRegulation() {
			return inapplicableRegulation;
		}
		
		@Override
		@RosettaAttribute("withdrawalReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawalReason")
		public String getWithdrawalReason() {
			return withdrawalReason;
		}
		
		@Override
		@RosettaAttribute("fullyWithdrawn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fullyWithdrawn")
		public Boolean getFullyWithdrawn() {
			return fullyWithdrawn;
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
		public RegulatoryWithdrawal build() {
			return this;
		}
		
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder toBuilder() {
			RegulatoryWithdrawal.RegulatoryWithdrawalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryWithdrawal.RegulatoryWithdrawalBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOnBehalfOf()).ifPresent(builder::setOnBehalfOf);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getPrimaryAssetClass()).ifPresent(builder::setPrimaryAssetClass);
			ofNullable(getInapplicableRegulation()).ifPresent(builder::setInapplicableRegulation);
			ofNullable(getWithdrawalReason()).ifPresent(builder::setWithdrawalReason);
			ofNullable(getFullyWithdrawn()).ifPresent(builder::setFullyWithdrawn);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryWithdrawal _that = getType().cast(o);
		
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(inapplicableRegulation, _that.getInapplicableRegulation())) return false;
			if (!Objects.equals(withdrawalReason, _that.getWithdrawalReason())) return false;
			if (!Objects.equals(fullyWithdrawn, _that.getFullyWithdrawn())) return false;
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
			_result = 31 * _result + (inapplicableRegulation != null ? inapplicableRegulation.hashCode() : 0);
			_result = 31 * _result + (withdrawalReason != null ? withdrawalReason.hashCode() : 0);
			_result = 31 * _result + (fullyWithdrawn != null ? fullyWithdrawn.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryWithdrawal {" +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"inapplicableRegulation=" + this.inapplicableRegulation + ", " +
				"withdrawalReason=" + this.withdrawalReason + ", " +
				"fullyWithdrawn=" + this.fullyWithdrawn + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryWithdrawal  ***********************/
	class RegulatoryWithdrawalBuilderImpl extends AddressedMessage.AddressedMessageBuilderImpl implements RegulatoryWithdrawal.RegulatoryWithdrawalBuilder {
	
		protected List<OnBehalfOf.OnBehalfOfBuilder> onBehalfOf = new ArrayList<>();
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder tradeIdentifier;
		protected AssetClass.AssetClassBuilder primaryAssetClass;
		protected List<InapplicableRegulation.InapplicableRegulationBuilder> inapplicableRegulation = new ArrayList<>();
		protected String withdrawalReason;
		protected Boolean fullyWithdrawn;
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
		@RosettaAttribute("inapplicableRegulation")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("inapplicableRegulation")
		public List<? extends InapplicableRegulation.InapplicableRegulationBuilder> getInapplicableRegulation() {
			return inapplicableRegulation;
		}
		
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder getOrCreateInapplicableRegulation(int index) {
			if (inapplicableRegulation==null) {
				this.inapplicableRegulation = new ArrayList<>();
			}
			return getIndex(inapplicableRegulation, index, () -> {
						InapplicableRegulation.InapplicableRegulationBuilder newInapplicableRegulation = InapplicableRegulation.builder();
						return newInapplicableRegulation;
					});
		}
		
		@Override
		@RosettaAttribute("withdrawalReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawalReason")
		public String getWithdrawalReason() {
			return withdrawalReason;
		}
		
		@Override
		@RosettaAttribute("fullyWithdrawn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fullyWithdrawn")
		public Boolean getFullyWithdrawn() {
			return fullyWithdrawn;
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
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inapplicableRegulation")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("inapplicableRegulation")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addInapplicableRegulation(InapplicableRegulation _inapplicableRegulation) {
			if (_inapplicableRegulation != null) {
				this.inapplicableRegulation.add(_inapplicableRegulation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addInapplicableRegulation(InapplicableRegulation _inapplicableRegulation, int idx) {
			getIndex(this.inapplicableRegulation, idx, () -> _inapplicableRegulation.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addInapplicableRegulation(List<? extends InapplicableRegulation> inapplicableRegulations) {
			if (inapplicableRegulations != null) {
				for (final InapplicableRegulation toAdd : inapplicableRegulations) {
					this.inapplicableRegulation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("inapplicableRegulation")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("inapplicableRegulation")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setInapplicableRegulation(List<? extends InapplicableRegulation> inapplicableRegulations) {
			if (inapplicableRegulations == null) {
				this.inapplicableRegulation = new ArrayList<>();
			} else {
				this.inapplicableRegulation = inapplicableRegulations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("withdrawalReason")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withdrawalReason")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setWithdrawalReason(String _withdrawalReason) {
			this.withdrawalReason = _withdrawalReason == null ? null : _withdrawalReason;
			return this;
		}
		
		@RosettaAttribute("fullyWithdrawn")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fullyWithdrawn")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setFullyWithdrawn(Boolean _fullyWithdrawn) {
			this.fullyWithdrawn = _fullyWithdrawn == null ? null : _fullyWithdrawn;
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder addParty(List<? extends Party> partys) {
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
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder setParty(List<? extends Party> partys) {
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
		public RegulatoryWithdrawal build() {
			return new RegulatoryWithdrawal.RegulatoryWithdrawalImpl(this);
		}
		
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder prune() {
			super.prune();
			onBehalfOf = onBehalfOf.stream().filter(b->b!=null).<OnBehalfOf.OnBehalfOfBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			if (primaryAssetClass!=null && !primaryAssetClass.prune().hasData()) primaryAssetClass = null;
			inapplicableRegulation = inapplicableRegulation.stream().filter(b->b!=null).<InapplicableRegulation.InapplicableRegulationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
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
			if (getInapplicableRegulation()!=null && getInapplicableRegulation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getWithdrawalReason()!=null) return true;
			if (getFullyWithdrawn()!=null) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryWithdrawal.RegulatoryWithdrawalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryWithdrawal.RegulatoryWithdrawalBuilder o = (RegulatoryWithdrawal.RegulatoryWithdrawalBuilder) other;
			
			merger.mergeRosetta(getOnBehalfOf(), o.getOnBehalfOf(), this::getOrCreateOnBehalfOf);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			merger.mergeRosetta(getPrimaryAssetClass(), o.getPrimaryAssetClass(), this::setPrimaryAssetClass);
			merger.mergeRosetta(getInapplicableRegulation(), o.getInapplicableRegulation(), this::getOrCreateInapplicableRegulation);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			merger.mergeBasic(getWithdrawalReason(), o.getWithdrawalReason(), this::setWithdrawalReason);
			merger.mergeBasic(getFullyWithdrawn(), o.getFullyWithdrawn(), this::setFullyWithdrawn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryWithdrawal _that = getType().cast(o);
		
			if (!ListEquals.listEquals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!ListEquals.listEquals(inapplicableRegulation, _that.getInapplicableRegulation())) return false;
			if (!Objects.equals(withdrawalReason, _that.getWithdrawalReason())) return false;
			if (!Objects.equals(fullyWithdrawn, _that.getFullyWithdrawn())) return false;
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
			_result = 31 * _result + (inapplicableRegulation != null ? inapplicableRegulation.hashCode() : 0);
			_result = 31 * _result + (withdrawalReason != null ? withdrawalReason.hashCode() : 0);
			_result = 31 * _result + (fullyWithdrawn != null ? fullyWithdrawn.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryWithdrawalBuilder {" +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"inapplicableRegulation=" + this.inapplicableRegulation + ", " +
				"withdrawalReason=" + this.withdrawalReason + ", " +
				"fullyWithdrawn=" + this.fullyWithdrawn + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
