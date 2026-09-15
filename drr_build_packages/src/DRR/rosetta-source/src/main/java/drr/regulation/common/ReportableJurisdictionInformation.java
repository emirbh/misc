package drr.regulation.common;

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
import drr.regulation.common.meta.ReportableJurisdictionInformationMeta;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the regulatory regime and supervisory body applicable to the transaction, along with the required jurisdiction-specific information concerning both the transaction and the involved parties.
 * @version 7.7.0
 */
@RosettaDataType(value="ReportableJurisdictionInformation", builder=ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportableJurisdictionInformation", model="drr", builder=ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilderImpl.class, version="7.7.0")
public interface ReportableJurisdictionInformation extends RosettaModelObject {

	ReportableJurisdictionInformationMeta metaData = new ReportableJurisdictionInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the regulatory regime applicable to the transaction.
	 */
	FieldWithMetaRegimeNameEnum getRegimeName();
	/**
	 * Identifies the supervisory body applicable to the transaction.
	 */
	FieldWithMetaSupervisoryBodyEnum getSupervisoryBody();
	/**
	 * Identifies jurisdiction-specific information regarding the transaction.
	 */
	TransactionInformation getTransactionInformation();
	/**
	 * Identifies jurisdiction-specific information concerning the involved parties.
	 */
	List<? extends JurisdictionPartyInformation> getPartyInformation();

	/*********************** Build Methods  ***********************/
	ReportableJurisdictionInformation build();
	
	ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder toBuilder();
	
	static ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder builder() {
		return new ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportableJurisdictionInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportableJurisdictionInformation> getType() {
		return ReportableJurisdictionInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("regimeName"), processor, FieldWithMetaRegimeNameEnum.class, getRegimeName());
		processRosetta(path.newSubPath("supervisoryBody"), processor, FieldWithMetaSupervisoryBodyEnum.class, getSupervisoryBody());
		processRosetta(path.newSubPath("transactionInformation"), processor, TransactionInformation.class, getTransactionInformation());
		processRosetta(path.newSubPath("partyInformation"), processor, JurisdictionPartyInformation.class, getPartyInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportableJurisdictionInformationBuilder extends ReportableJurisdictionInformation, RosettaModelObjectBuilder {
		FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder getOrCreateRegimeName();
		@Override
		FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder getRegimeName();
		FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder getOrCreateSupervisoryBody();
		@Override
		FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder getSupervisoryBody();
		TransactionInformation.TransactionInformationBuilder getOrCreateTransactionInformation();
		@Override
		TransactionInformation.TransactionInformationBuilder getTransactionInformation();
		JurisdictionPartyInformation.JurisdictionPartyInformationBuilder getOrCreatePartyInformation(int index);
		@Override
		List<? extends JurisdictionPartyInformation.JurisdictionPartyInformationBuilder> getPartyInformation();
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setRegimeName(FieldWithMetaRegimeNameEnum regimeName);
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setRegimeNameValue(RegimeNameEnum regimeName);
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setSupervisoryBody(FieldWithMetaSupervisoryBodyEnum supervisoryBody);
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setSupervisoryBodyValue(SupervisoryBodyEnum supervisoryBody);
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setTransactionInformation(TransactionInformation transactionInformation);
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder addPartyInformation(JurisdictionPartyInformation partyInformation);
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder addPartyInformation(JurisdictionPartyInformation partyInformation, int idx);
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder addPartyInformation(List<? extends JurisdictionPartyInformation> partyInformation);
		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setPartyInformation(List<? extends JurisdictionPartyInformation> partyInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("regimeName"), processor, FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder.class, getRegimeName());
			processRosetta(path.newSubPath("supervisoryBody"), processor, FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder.class, getSupervisoryBody());
			processRosetta(path.newSubPath("transactionInformation"), processor, TransactionInformation.TransactionInformationBuilder.class, getTransactionInformation());
			processRosetta(path.newSubPath("partyInformation"), processor, JurisdictionPartyInformation.JurisdictionPartyInformationBuilder.class, getPartyInformation());
		}
		

		ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder prune();
	}

	/*********************** Immutable Implementation of ReportableJurisdictionInformation  ***********************/
	class ReportableJurisdictionInformationImpl implements ReportableJurisdictionInformation {
		private final FieldWithMetaRegimeNameEnum regimeName;
		private final FieldWithMetaSupervisoryBodyEnum supervisoryBody;
		private final TransactionInformation transactionInformation;
		private final List<? extends JurisdictionPartyInformation> partyInformation;
		
		protected ReportableJurisdictionInformationImpl(ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder builder) {
			this.regimeName = ofNullable(builder.getRegimeName()).map(f->f.build()).orElse(null);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).map(f->f.build()).orElse(null);
			this.transactionInformation = ofNullable(builder.getTransactionInformation()).map(f->f.build()).orElse(null);
			this.partyInformation = ofNullable(builder.getPartyInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("regimeName")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("regimeName")
		public FieldWithMetaRegimeNameEnum getRegimeName() {
			return regimeName;
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supervisoryBody")
		public FieldWithMetaSupervisoryBodyEnum getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("transactionInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transactionInformation")
		public TransactionInformation getTransactionInformation() {
			return transactionInformation;
		}
		
		@Override
		@RosettaAttribute("partyInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyInformation")
		public List<? extends JurisdictionPartyInformation> getPartyInformation() {
			return partyInformation;
		}
		
		@Override
		public ReportableJurisdictionInformation build() {
			return this;
		}
		
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder toBuilder() {
			ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder builder) {
			ofNullable(getRegimeName()).ifPresent(builder::setRegimeName);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getTransactionInformation()).ifPresent(builder::setTransactionInformation);
			ofNullable(getPartyInformation()).ifPresent(builder::setPartyInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableJurisdictionInformation _that = getType().cast(o);
		
			if (!Objects.equals(regimeName, _that.getRegimeName())) return false;
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(transactionInformation, _that.getTransactionInformation())) return false;
			if (!ListEquals.listEquals(partyInformation, _that.getPartyInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regimeName != null ? regimeName.hashCode() : 0);
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (transactionInformation != null ? transactionInformation.hashCode() : 0);
			_result = 31 * _result + (partyInformation != null ? partyInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableJurisdictionInformation {" +
				"regimeName=" + this.regimeName + ", " +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"transactionInformation=" + this.transactionInformation + ", " +
				"partyInformation=" + this.partyInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportableJurisdictionInformation  ***********************/
	class ReportableJurisdictionInformationBuilderImpl implements ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder {
	
		protected FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder regimeName;
		protected FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder supervisoryBody;
		protected TransactionInformation.TransactionInformationBuilder transactionInformation;
		protected List<JurisdictionPartyInformation.JurisdictionPartyInformationBuilder> partyInformation = new ArrayList<>();
		
		@Override
		@RosettaAttribute("regimeName")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("regimeName")
		public FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder getRegimeName() {
			return regimeName;
		}
		
		@Override
		public FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder getOrCreateRegimeName() {
			FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder result;
			if (regimeName!=null) {
				result = regimeName;
			}
			else {
				result = regimeName = FieldWithMetaRegimeNameEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supervisoryBody")
		public FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		public FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder getOrCreateSupervisoryBody() {
			FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder result;
			if (supervisoryBody!=null) {
				result = supervisoryBody;
			}
			else {
				result = supervisoryBody = FieldWithMetaSupervisoryBodyEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transactionInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transactionInformation")
		public TransactionInformation.TransactionInformationBuilder getTransactionInformation() {
			return transactionInformation;
		}
		
		@Override
		public TransactionInformation.TransactionInformationBuilder getOrCreateTransactionInformation() {
			TransactionInformation.TransactionInformationBuilder result;
			if (transactionInformation!=null) {
				result = transactionInformation;
			}
			else {
				result = transactionInformation = TransactionInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyInformation")
		public List<? extends JurisdictionPartyInformation.JurisdictionPartyInformationBuilder> getPartyInformation() {
			return partyInformation;
		}
		
		@Override
		public JurisdictionPartyInformation.JurisdictionPartyInformationBuilder getOrCreatePartyInformation(int index) {
			if (partyInformation==null) {
				this.partyInformation = new ArrayList<>();
			}
			return getIndex(partyInformation, index, () -> {
						JurisdictionPartyInformation.JurisdictionPartyInformationBuilder newPartyInformation = JurisdictionPartyInformation.builder();
						return newPartyInformation;
					});
		}
		
		@RosettaAttribute("regimeName")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("regimeName")
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setRegimeName(FieldWithMetaRegimeNameEnum _regimeName) {
			this.regimeName = _regimeName == null ? null : _regimeName.toBuilder();
			return this;
		}
		
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setRegimeNameValue(RegimeNameEnum _regimeName) {
			this.getOrCreateRegimeName().setValue(_regimeName);
			return this;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("supervisoryBody")
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setSupervisoryBody(FieldWithMetaSupervisoryBodyEnum _supervisoryBody) {
			this.supervisoryBody = _supervisoryBody == null ? null : _supervisoryBody.toBuilder();
			return this;
		}
		
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setSupervisoryBodyValue(SupervisoryBodyEnum _supervisoryBody) {
			this.getOrCreateSupervisoryBody().setValue(_supervisoryBody);
			return this;
		}
		
		@RosettaAttribute("transactionInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transactionInformation")
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setTransactionInformation(TransactionInformation _transactionInformation) {
			this.transactionInformation = _transactionInformation == null ? null : _transactionInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyInformation")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyInformation")
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder addPartyInformation(JurisdictionPartyInformation _partyInformation) {
			if (_partyInformation != null) {
				this.partyInformation.add(_partyInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder addPartyInformation(JurisdictionPartyInformation _partyInformation, int idx) {
			getIndex(this.partyInformation, idx, () -> _partyInformation.toBuilder());
			return this;
		}
		
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder addPartyInformation(List<? extends JurisdictionPartyInformation> partyInformations) {
			if (partyInformations != null) {
				for (final JurisdictionPartyInformation toAdd : partyInformations) {
					this.partyInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("partyInformation")
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder setPartyInformation(List<? extends JurisdictionPartyInformation> partyInformations) {
			if (partyInformations == null) {
				this.partyInformation = new ArrayList<>();
			} else {
				this.partyInformation = partyInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReportableJurisdictionInformation build() {
			return new ReportableJurisdictionInformation.ReportableJurisdictionInformationImpl(this);
		}
		
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder prune() {
			if (regimeName!=null && !regimeName.prune().hasData()) regimeName = null;
			if (supervisoryBody!=null && !supervisoryBody.prune().hasData()) supervisoryBody = null;
			if (transactionInformation!=null && !transactionInformation.prune().hasData()) transactionInformation = null;
			partyInformation = partyInformation.stream().filter(b->b!=null).<JurisdictionPartyInformation.JurisdictionPartyInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRegimeName()!=null) return true;
			if (getSupervisoryBody()!=null) return true;
			if (getTransactionInformation()!=null && getTransactionInformation().hasData()) return true;
			if (getPartyInformation()!=null && getPartyInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder o = (ReportableJurisdictionInformation.ReportableJurisdictionInformationBuilder) other;
			
			merger.mergeRosetta(getRegimeName(), o.getRegimeName(), this::setRegimeName);
			merger.mergeRosetta(getSupervisoryBody(), o.getSupervisoryBody(), this::setSupervisoryBody);
			merger.mergeRosetta(getTransactionInformation(), o.getTransactionInformation(), this::setTransactionInformation);
			merger.mergeRosetta(getPartyInformation(), o.getPartyInformation(), this::getOrCreatePartyInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableJurisdictionInformation _that = getType().cast(o);
		
			if (!Objects.equals(regimeName, _that.getRegimeName())) return false;
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(transactionInformation, _that.getTransactionInformation())) return false;
			if (!ListEquals.listEquals(partyInformation, _that.getPartyInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regimeName != null ? regimeName.hashCode() : 0);
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (transactionInformation != null ? transactionInformation.hashCode() : 0);
			_result = 31 * _result + (partyInformation != null ? partyInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableJurisdictionInformationBuilder {" +
				"regimeName=" + this.regimeName + ", " +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"transactionInformation=" + this.transactionInformation + ", " +
				"partyInformation=" + this.partyInformation +
			'}';
		}
	}
}
