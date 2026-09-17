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
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.reg.fpmlreporting.shared.meta.RegulatoryReportingStatusMeta;
import fpml.consolidated.shared.Party;
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
 * Provision Used to report the status of reporting on a trade to any regulators.
 *
 */
@RosettaDataType(value="RegulatoryReportingStatus", builder=RegulatoryReportingStatus.RegulatoryReportingStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingStatus", model="fpml", builder=RegulatoryReportingStatus.RegulatoryReportingStatusBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingStatus extends RegulatoryReportingStatusMessage {

	RegulatoryReportingStatusMeta metaData = new RegulatoryReportingStatusMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RegulatoryReportingStatus build();
	
	RegulatoryReportingStatus.RegulatoryReportingStatusBuilder toBuilder();
	
	static RegulatoryReportingStatus.RegulatoryReportingStatusBuilder builder() {
		return new RegulatoryReportingStatus.RegulatoryReportingStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingStatus> getType() {
		return RegulatoryReportingStatus.class;
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
	interface RegulatoryReportingStatusBuilder extends RegulatoryReportingStatus, RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilder {
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setActualBuild(Integer actualBuild);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setHeader(ResponseMessageHeader header);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setTradeIdentifier(PartyTradeIdentifier tradeIdentifier);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addReportingStatus(ReportingStatus reportingStatus);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addReportingStatus(ReportingStatus reportingStatus, int idx);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addReportingStatus(List<? extends ReportingStatus> reportingStatus);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setReportingStatus(List<? extends ReportingStatus> reportingStatus);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addParty(Party party);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addParty(Party party, int idx);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addParty(List<? extends Party> party);
		@Override
		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setParty(List<? extends Party> party);

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
		

		RegulatoryReportingStatus.RegulatoryReportingStatusBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingStatus  ***********************/
	class RegulatoryReportingStatusImpl extends RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageImpl implements RegulatoryReportingStatus {
		
		protected RegulatoryReportingStatusImpl(RegulatoryReportingStatus.RegulatoryReportingStatusBuilder builder) {
			super(builder);
		}
		
		@Override
		public RegulatoryReportingStatus build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder toBuilder() {
			RegulatoryReportingStatus.RegulatoryReportingStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingStatus.RegulatoryReportingStatusBuilder builder) {
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
			return "RegulatoryReportingStatus {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingStatus  ***********************/
	class RegulatoryReportingStatusBuilderImpl extends RegulatoryReportingStatusMessage.RegulatoryReportingStatusMessageBuilderImpl implements RegulatoryReportingStatus.RegulatoryReportingStatusBuilder {
	
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeIdentifier")
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setTradeIdentifier(PartyTradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingStatus")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingStatus")
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addReportingStatus(ReportingStatus _reportingStatus) {
			if (_reportingStatus != null) {
				this.reportingStatus.add(_reportingStatus.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addReportingStatus(ReportingStatus _reportingStatus, int idx) {
			getIndex(this.reportingStatus, idx, () -> _reportingStatus.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addReportingStatus(List<? extends ReportingStatus> reportingStatuss) {
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
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setReportingStatus(List<? extends ReportingStatus> reportingStatuss) {
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
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder addParty(List<? extends Party> partys) {
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
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder setParty(List<? extends Party> partys) {
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
		public RegulatoryReportingStatus build() {
			return new RegulatoryReportingStatus.RegulatoryReportingStatusImpl(this);
		}
		
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder prune() {
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
		public RegulatoryReportingStatus.RegulatoryReportingStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryReportingStatus.RegulatoryReportingStatusBuilder o = (RegulatoryReportingStatus.RegulatoryReportingStatusBuilder) other;
			
			
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
			return "RegulatoryReportingStatusBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
