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
import fpml.consolidated.msg.Message;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.reg.fpmlreporting.shared.meta.RegulatoryReportingStatusMessageMeta;
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
 * Provision A type defining message that can be used for returning the regulatory reporting status of a trade.
 *
 */
@RosettaDataType(value="RegulatoryReportingStatusMessage", builder=RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingStatusMessage", model="fpml", builder=RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingStatusMessage extends Message {

	RegulatoryReportingStatusMessageMeta metaData = new RegulatoryReportingStatusMessageMeta();

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
	 * Provision Reference information about parties, business units, and persons involed in the trade.
	 *
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingStatusMessage build();
	
	RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder toBuilder();
	
	static RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder builder() {
		return new RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingStatusMessage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingStatusMessage> getType() {
		return RegulatoryReportingStatusMessage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("reportingStatus"), processor, ReportingStatus.class, getReportingStatus());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingStatusMessageBuilder extends RegulatoryReportingStatusMessage, Message.MessageBuilder {
		ResponseMessageHeader.ResponseMessageHeaderBuilder getOrCreateHeader();
		@Override
		ResponseMessageHeader.ResponseMessageHeaderBuilder getHeader();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier();
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getTradeIdentifier();
		ReportingStatus.ReportingStatusBuilder getOrCreateReportingStatus(int index);
		@Override
		List<? extends ReportingStatus.ReportingStatusBuilder> getReportingStatus();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setActualBuild(Integer actualBuild);
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setHeader(ResponseMessageHeader header);
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addReportingStatus(ReportingStatus reportingStatus);
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addReportingStatus(ReportingStatus reportingStatus, int idx);
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addReportingStatus(List<? extends ReportingStatus> reportingStatus);
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setReportingStatus(List<? extends ReportingStatus> reportingStatus);
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addParty(Party party);
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addParty(Party party, int idx);
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addParty(List<? extends Party> party);
		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setParty(List<? extends Party> party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("reportingStatus"), processor, ReportingStatus.ReportingStatusBuilder.class, getReportingStatus());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingStatusMessage  ***********************/
	class RegulatoryReportingStatusMessageImpl extends Message.MessageImpl implements RegulatoryReportingStatusMessage {
		private final ResponseMessageHeader header;
		private final PartyTradeIdentifier tradeIdentifier;
		private final List<? extends ReportingStatus> reportingStatus;
		private final List<? extends Party> party;
		
		protected RegulatoryReportingStatusMessageImpl(RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
			this.reportingStatus = ofNullable(builder.getReportingStatus()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public RegulatoryReportingStatusMessage build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder toBuilder() {
			RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getReportingStatus()).ifPresent(builder::setReportingStatus);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryReportingStatusMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!ListEquals.listEquals(reportingStatus, _that.getReportingStatus())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (reportingStatus != null ? reportingStatus.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingStatusMessage {" +
				"header=" + this.header + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"reportingStatus=" + this.reportingStatus + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingStatusMessage  ***********************/
	class RegulatoryReportingStatusMessageBuilderImpl extends Message.MessageBuilderImpl implements RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder {
	
		protected ResponseMessageHeader.ResponseMessageHeaderBuilder header;
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder tradeIdentifier;
		protected List<ReportingStatus.ReportingStatusBuilder> reportingStatus = new ArrayList<>();
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
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeIdentifier")
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingStatus")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingStatus")
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addReportingStatus(ReportingStatus _reportingStatus) {
			if (_reportingStatus != null) {
				this.reportingStatus.add(_reportingStatus.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addReportingStatus(ReportingStatus _reportingStatus, int idx) {
			getIndex(this.reportingStatus, idx, () -> _reportingStatus.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addReportingStatus(List<? extends ReportingStatus> reportingStatuss) {
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
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setReportingStatus(List<? extends ReportingStatus> reportingStatuss) {
			if (reportingStatuss == null) {
				this.reportingStatus = new ArrayList<>();
			} else {
				this.reportingStatus = reportingStatuss.stream()
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
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder addParty(List<? extends Party> partys) {
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
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder setParty(List<? extends Party> partys) {
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
		public RegulatoryReportingStatusMessage build() {
			return new RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageImpl(this);
		}
		
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			reportingStatus = reportingStatus.stream().filter(b->b!=null).<ReportingStatus.ReportingStatusBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			if (getReportingStatus()!=null && getReportingStatus().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder o = (RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			merger.mergeRosetta(getReportingStatus(), o.getReportingStatus(), this::getOrCreateReportingStatus);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryReportingStatusMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!ListEquals.listEquals(reportingStatus, _that.getReportingStatus())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (reportingStatus != null ? reportingStatus.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingStatusMessageBuilder {" +
				"header=" + this.header + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"reportingStatus=" + this.reportingStatus + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
