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
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.msg.Message;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryReportingAcknowledgementMeta;
import fpml.consolidated.reg.fpmlreporting.shared.ReportingStatus;
import fpml.consolidated.shared.Party;
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
 * Provision A type defining an acknowledgement to a regulatory reporting submission, e.g. regulatoryDisclosure or regulatoryWithdrawal.
 *
 */
@RosettaDataType(value="RegulatoryReportingAcknowledgement", builder=RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingAcknowledgement", model="fpml", builder=RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingAcknowledgement extends Message {

	RegulatoryReportingAcknowledgementMeta metaData = new RegulatoryReportingAcknowledgementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Standard FpML message header
	 *
	 */
	ResponseMessageHeader getHeader();
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
	 * Provision Information about how the position is being reported to regulators.
	 *
	 */
	List<? extends ReportingStatus> getReportingStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	AdditionalData getAdditionalData();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference information about parties, business units, and persons involed in the trade.
	 *
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingAcknowledgement build();
	
	RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder toBuilder();
	
	static RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder builder() {
		return new RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingAcknowledgement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingAcknowledgement> getType() {
		return RegulatoryReportingAcknowledgement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("reportingStatus"), processor, ReportingStatus.class, getReportingStatus());
		processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.class, getAdditionalData());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingAcknowledgementBuilder extends RegulatoryReportingAcknowledgement, Message.MessageBuilder {
		ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader();
		@Override
		ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier();
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getTradeIdentifier();
		ReportingStatus.ReportingStatusBuilder getOrCreateReportingStatus(int index);
		@Override
		List<? extends ReportingStatus.ReportingStatusBuilder> getReportingStatus();
		AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData();
		@Override
		AdditionalData.AdditionalDataBuilder getAdditionalData();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setActualBuild(Integer actualBuild);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setHeader(ResponseMessageHeader header);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addReportingStatus(ReportingStatus reportingStatus);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addReportingStatus(ReportingStatus reportingStatus, int idx);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addReportingStatus(List<? extends ReportingStatus> reportingStatus);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setReportingStatus(List<? extends ReportingStatus> reportingStatus);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setAdditionalData(AdditionalData additionalData);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addParty(Party party);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addParty(Party party, int idx);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addParty(List<? extends Party> party);
		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setParty(List<? extends Party> party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("reportingStatus"), processor, ReportingStatus.ReportingStatusBuilder.class, getReportingStatus());
			processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.AdditionalDataBuilder.class, getAdditionalData());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingAcknowledgement  ***********************/
	class RegulatoryReportingAcknowledgementImpl extends Message.MessageImpl implements RegulatoryReportingAcknowledgement {
		private final ResponseMessageHeader header;
		private final PartyTradeIdentifier tradeIdentifier;
		private final List<? extends ReportingStatus> reportingStatus;
		private final AdditionalData additionalData;
		private final List<? extends Party> party;
		
		protected RegulatoryReportingAcknowledgementImpl(RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
			this.reportingStatus = ofNullable(builder.getReportingStatus()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalData = ofNullable(builder.getAdditionalData()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public ResponseMessageHeader getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public PartyTradeIdentifier getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("reportingStatus")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingStatus")
		public List<? extends ReportingStatus> getReportingStatus() {
			return reportingStatus;
		}
		
		@Override
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalData")
		public AdditionalData getAdditionalData() {
			return additionalData;
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
		public RegulatoryReportingAcknowledgement build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder toBuilder() {
			RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getReportingStatus()).ifPresent(builder::setReportingStatus);
			ofNullable(getAdditionalData()).ifPresent(builder::setAdditionalData);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryReportingAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!ListEquals.listEquals(reportingStatus, _that.getReportingStatus())) return false;
			if (!Objects.equals(additionalData, _that.getAdditionalData())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (reportingStatus != null ? reportingStatus.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingAcknowledgement {" +
				"header=" + this.header + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"reportingStatus=" + this.reportingStatus + ", " +
				"additionalData=" + this.additionalData + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingAcknowledgement  ***********************/
	class RegulatoryReportingAcknowledgementBuilderImpl extends Message.MessageBuilderImpl implements RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder {
	
		protected ResponseMessageHeader.ResponseMessageHeaderBuilder header;
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder tradeIdentifier;
		protected List<ReportingStatus.ReportingStatusBuilder> reportingStatus = new ArrayList<>();
		protected AdditionalData.AdditionalDataBuilder additionalData;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader() {
			ResponseMessageHeader.ResponseMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = ResponseMessageHeader.builder();
			}
			
			return result;
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
		@RosettaAttribute("reportingStatus")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingStatus")
		public List<? extends ReportingStatus.ReportingStatusBuilder> getReportingStatus() {
			return reportingStatus;
		}
		
		@Override
		public ReportingStatus.ReportingStatusBuilder getOrCreateReportingStatus(int index) {
			if (reportingStatus==null) {
				this.reportingStatus = new ArrayList<>();
			}
			return getIndex(reportingStatus, index, () -> {
						ReportingStatus.ReportingStatusBuilder newReportingStatus = ReportingStatus.builder();
						return newReportingStatus;
					});
		}
		
		@Override
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalData")
		public AdditionalData.AdditionalDataBuilder getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData() {
			AdditionalData.AdditionalDataBuilder result;
			if (additionalData!=null) {
				result = additionalData;
			}
			else {
				result = additionalData = AdditionalData.builder();
			}
			
			return result;
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
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeIdentifier")
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingStatus")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingStatus")
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addReportingStatus(ReportingStatus _reportingStatus) {
			if (_reportingStatus != null) {
				this.reportingStatus.add(_reportingStatus.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addReportingStatus(ReportingStatus _reportingStatus, int idx) {
			getIndex(this.reportingStatus, idx, () -> _reportingStatus.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addReportingStatus(List<? extends ReportingStatus> reportingStatuss) {
			if (reportingStatuss != null) {
				for (final ReportingStatus toAdd : reportingStatuss) {
					this.reportingStatus.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reportingStatus")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reportingStatus")
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setReportingStatus(List<? extends ReportingStatus> reportingStatuss) {
			if (reportingStatuss == null) {
				this.reportingStatus = new ArrayList<>();
			} else {
				this.reportingStatus = reportingStatuss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalData")
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setAdditionalData(AdditionalData _additionalData) {
			this.additionalData = _additionalData == null ? null : _additionalData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder addParty(List<? extends Party> partys) {
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
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder setParty(List<? extends Party> partys) {
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
		public RegulatoryReportingAcknowledgement build() {
			return new RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementImpl(this);
		}
		
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			reportingStatus = reportingStatus.stream().filter(b->b!=null).<ReportingStatus.ReportingStatusBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (additionalData!=null && !additionalData.prune().hasData()) additionalData = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			if (getReportingStatus()!=null && getReportingStatus().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalData()!=null && getAdditionalData().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder o = (RegulatoryReportingAcknowledgement.RegulatoryReportingAcknowledgementBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			merger.mergeRosetta(getReportingStatus(), o.getReportingStatus(), this::getOrCreateReportingStatus);
			merger.mergeRosetta(getAdditionalData(), o.getAdditionalData(), this::setAdditionalData);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryReportingAcknowledgement _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!ListEquals.listEquals(reportingStatus, _that.getReportingStatus())) return false;
			if (!Objects.equals(additionalData, _that.getAdditionalData())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (reportingStatus != null ? reportingStatus.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingAcknowledgementBuilder {" +
				"header=" + this.header + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"reportingStatus=" + this.reportingStatus + ", " +
				"additionalData=" + this.additionalData + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
