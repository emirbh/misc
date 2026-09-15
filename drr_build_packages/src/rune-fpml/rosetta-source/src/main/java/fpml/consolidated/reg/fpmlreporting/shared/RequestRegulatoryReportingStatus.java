package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.reg.fpmlreporting.shared.meta.RequestRegulatoryReportingStatusMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.RelatedParty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Used to request the status of reporting on a trade to any regulators.
 *
 */
@RosettaDataType(value="RequestRegulatoryReportingStatus", builder=RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestRegulatoryReportingStatus", model="fpml", builder=RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilderImpl.class, version="2.1.1")
public interface RequestRegulatoryReportingStatus extends RequestRegulatoryReportingStatusMessage {

	RequestRegulatoryReportingStatusMeta metaData = new RequestRegulatoryReportingStatusMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RequestRegulatoryReportingStatus build();
	
	RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder toBuilder();
	
	static RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder builder() {
		return new RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestRegulatoryReportingStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestRegulatoryReportingStatus> getType() {
		return RequestRegulatoryReportingStatus.class;
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
	interface RequestRegulatoryReportingStatusBuilder extends RequestRegulatoryReportingStatus, RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilder {
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setActualBuild(Integer actualBuild);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setHeader(NotificationMessageHeader header);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addRelatedParty(RelatedParty relatedParty);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addParty(Party party);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addParty(Party party, int idx);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addParty(List<? extends Party> party);
		@Override
		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setParty(List<? extends Party> party);

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
		

		RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder prune();
	}

	/*********************** Immutable Implementation of RequestRegulatoryReportingStatus  ***********************/
	class RequestRegulatoryReportingStatusImpl extends RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageImpl implements RequestRegulatoryReportingStatus {
		
		protected RequestRegulatoryReportingStatusImpl(RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder builder) {
			super(builder);
		}
		
		@Override
		public RequestRegulatoryReportingStatus build() {
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder toBuilder() {
			RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestRegulatoryReportingStatus {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestRegulatoryReportingStatus  ***********************/
	class RequestRegulatoryReportingStatusBuilderImpl extends RequestRegulatoryReportingStatusMessage.RequestRegulatoryReportingStatusMessageBuilderImpl implements RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder addParty(List<? extends Party> partys) {
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
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder setParty(List<? extends Party> partys) {
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
		public RequestRegulatoryReportingStatus build() {
			return new RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusImpl(this);
		}
		
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder o = (RequestRegulatoryReportingStatus.RequestRegulatoryReportingStatusBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestRegulatoryReportingStatusBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
