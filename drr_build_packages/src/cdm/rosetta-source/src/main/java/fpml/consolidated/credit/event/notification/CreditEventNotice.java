package fpml.consolidated.credit.event.notification;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.credit.event.notification.meta.CreditEventNoticeMeta;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Resource;
import java.time.ZonedDateTime;
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
 * Provision A global element used to hold CENs.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A global element used to hold CENs.
 *
 */
@RosettaDataType(value="CreditEventNotice", builder=CreditEventNotice.CreditEventNoticeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditEventNotice", model="fpml", builder=CreditEventNotice.CreditEventNoticeBuilderImpl.class, version="2.1.1")
public interface CreditEventNotice extends CreditEventNoticeDocument {

	CreditEventNoticeMeta metaData = new CreditEventNoticeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CreditEventNotice build();
	
	CreditEventNotice.CreditEventNoticeBuilder toBuilder();
	
	static CreditEventNotice.CreditEventNoticeBuilder builder() {
		return new CreditEventNotice.CreditEventNoticeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventNotice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditEventNotice> getType() {
		return CreditEventNotice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("affectedTransactions"), processor, AffectedTransactions.class, getAffectedTransactions());
		processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.class, getReferenceEntity());
		processRosetta(path.newSubPath("creditEvent"), processor, CreditEvent.class, getCreditEvent());
		processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, Resource.class, getPubliclyAvailableInformation());
		processRosetta(path.newSubPath("notifyingPartyReference"), processor, PartyReference.class, getNotifyingPartyReference());
		processRosetta(path.newSubPath("notifiedPartyReference"), processor, PartyReference.class, getNotifiedPartyReference());
		processor.processBasic(path.newSubPath("creditEventNoticeDate"), ZonedDateTime.class, getCreditEventNoticeDate(), this);
		processor.processBasic(path.newSubPath("creditEventDate"), ZonedDateTime.class, getCreditEventDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventNoticeBuilder extends CreditEventNotice, CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder {
		@Override
		CreditEventNotice.CreditEventNoticeBuilder setAffectedTransactions(AffectedTransactions affectedTransactions);
		@Override
		CreditEventNotice.CreditEventNoticeBuilder setReferenceEntity(LegalEntity referenceEntity);
		@Override
		CreditEventNotice.CreditEventNoticeBuilder setCreditEvent(CreditEvent creditEvent);
		@Override
		CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation);
		@Override
		CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation, int idx);
		@Override
		CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation);
		@Override
		CreditEventNotice.CreditEventNoticeBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation);
		@Override
		CreditEventNotice.CreditEventNoticeBuilder setNotifyingPartyReference(PartyReference notifyingPartyReference);
		@Override
		CreditEventNotice.CreditEventNoticeBuilder setNotifiedPartyReference(PartyReference notifiedPartyReference);
		@Override
		CreditEventNotice.CreditEventNoticeBuilder setCreditEventNoticeDate(ZonedDateTime creditEventNoticeDate);
		@Override
		CreditEventNotice.CreditEventNoticeBuilder setCreditEventDate(ZonedDateTime creditEventDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("affectedTransactions"), processor, AffectedTransactions.AffectedTransactionsBuilder.class, getAffectedTransactions());
			processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getReferenceEntity());
			processRosetta(path.newSubPath("creditEvent"), processor, CreditEvent.CreditEventBuilder.class, getCreditEvent());
			processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, Resource.ResourceBuilder.class, getPubliclyAvailableInformation());
			processRosetta(path.newSubPath("notifyingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getNotifyingPartyReference());
			processRosetta(path.newSubPath("notifiedPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getNotifiedPartyReference());
			processor.processBasic(path.newSubPath("creditEventNoticeDate"), ZonedDateTime.class, getCreditEventNoticeDate(), this);
			processor.processBasic(path.newSubPath("creditEventDate"), ZonedDateTime.class, getCreditEventDate(), this);
		}
		

		CreditEventNotice.CreditEventNoticeBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventNotice  ***********************/
	class CreditEventNoticeImpl extends CreditEventNoticeDocument.CreditEventNoticeDocumentImpl implements CreditEventNotice {
		
		protected CreditEventNoticeImpl(CreditEventNotice.CreditEventNoticeBuilder builder) {
			super(builder);
		}
		
		@Override
		public CreditEventNotice build() {
			return this;
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder toBuilder() {
			CreditEventNotice.CreditEventNoticeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventNotice.CreditEventNoticeBuilder builder) {
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
			return "CreditEventNotice {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditEventNotice  ***********************/
	class CreditEventNoticeBuilderImpl extends CreditEventNoticeDocument.CreditEventNoticeDocumentBuilderImpl implements CreditEventNotice.CreditEventNoticeBuilder {
	
		
		@RosettaAttribute("affectedTransactions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("affectedTransactions")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setAffectedTransactions(AffectedTransactions _affectedTransactions) {
			this.affectedTransactions = _affectedTransactions == null ? null : _affectedTransactions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setReferenceEntity(LegalEntity _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEvent")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setCreditEvent(CreditEvent _creditEvent) {
			this.creditEvent = _creditEvent == null ? null : _creditEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("publiclyAvailableInformation")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(Resource _publiclyAvailableInformation) {
			if (_publiclyAvailableInformation != null) {
				this.publiclyAvailableInformation.add(_publiclyAvailableInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(Resource _publiclyAvailableInformation, int idx) {
			getIndex(this.publiclyAvailableInformation, idx, () -> _publiclyAvailableInformation.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
			if (publiclyAvailableInformations != null) {
				for (final Resource toAdd : publiclyAvailableInformations) {
					this.publiclyAvailableInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("publiclyAvailableInformation")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
			if (publiclyAvailableInformations == null) {
				this.publiclyAvailableInformation = new ArrayList<>();
			} else {
				this.publiclyAvailableInformation = publiclyAvailableInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("notifyingPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notifyingPartyReference")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setNotifyingPartyReference(PartyReference _notifyingPartyReference) {
			this.notifyingPartyReference = _notifyingPartyReference == null ? null : _notifyingPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notifiedPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notifiedPartyReference")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setNotifiedPartyReference(PartyReference _notifiedPartyReference) {
			this.notifiedPartyReference = _notifiedPartyReference == null ? null : _notifiedPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditEventNoticeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEventNoticeDate")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setCreditEventNoticeDate(ZonedDateTime _creditEventNoticeDate) {
			this.creditEventNoticeDate = _creditEventNoticeDate == null ? null : _creditEventNoticeDate;
			return this;
		}
		
		@RosettaAttribute("creditEventDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEventDate")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setCreditEventDate(ZonedDateTime _creditEventDate) {
			this.creditEventDate = _creditEventDate == null ? null : _creditEventDate;
			return this;
		}
		
		@Override
		public CreditEventNotice build() {
			return new CreditEventNotice.CreditEventNoticeImpl(this);
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder prune() {
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
		public CreditEventNotice.CreditEventNoticeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditEventNotice.CreditEventNoticeBuilder o = (CreditEventNotice.CreditEventNoticeBuilder) other;
			
			
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
			return "CreditEventNoticeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
