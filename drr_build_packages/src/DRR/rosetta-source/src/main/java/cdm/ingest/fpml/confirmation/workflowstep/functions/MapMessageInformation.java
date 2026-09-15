package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.event.workflow.MessageInformation;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.msg.MessageAddress;
import fpml.consolidated.msg.MessageId;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMessageInformation.MapMessageInformationDefault.class)
public abstract class MapMessageInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlMessageId 
	* @param fpmlSentBy 
	* @param fpmlSendToList 
	* @return messageInfo 
	*/
	public MessageInformation evaluate(MessageId fpmlMessageId, MessageAddress fpmlSentBy, List<? extends MessageAddress> fpmlSendToList) {
		MessageInformation.MessageInformationBuilder messageInfoBuilder = doEvaluate(fpmlMessageId, fpmlSentBy, fpmlSendToList);
		
		final MessageInformation messageInfo;
		if (messageInfoBuilder == null) {
			messageInfo = null;
		} else {
			messageInfo = messageInfoBuilder.build();
			objectValidator.validate(MessageInformation.class, messageInfo);
		}
		
		return messageInfo;
	}

	protected abstract MessageInformation.MessageInformationBuilder doEvaluate(MessageId fpmlMessageId, MessageAddress fpmlSentBy, List<? extends MessageAddress> fpmlSendToList);

	public static class MapMessageInformationDefault extends MapMessageInformation {
		@Override
		protected MessageInformation.MessageInformationBuilder doEvaluate(MessageId fpmlMessageId, MessageAddress fpmlSentBy, List<? extends MessageAddress> fpmlSendToList) {
			if (fpmlSendToList == null) {
				fpmlSendToList = Collections.emptyList();
			}
			MessageInformation.MessageInformationBuilder messageInfo = MessageInformation.builder();
			return assignOutput(messageInfo, fpmlMessageId, fpmlSentBy, fpmlSendToList);
		}
		
		protected MessageInformation.MessageInformationBuilder assignOutput(MessageInformation.MessageInformationBuilder messageInfo, MessageId fpmlMessageId, MessageAddress fpmlSentBy, List<? extends MessageAddress> fpmlSendToList) {
			messageInfo = toBuilder(MessageInformation.builder()
				.setMessageId(mapStringWithScheme.evaluate(MapperS.of(fpmlMessageId).<String>map("getValue", messageId -> messageId.getValue()).get(), MapperS.of(fpmlMessageId).<String>map("getMessageIdScheme", messageId -> messageId.getMessageIdScheme()).get()))
				.setSentBy(mapStringWithScheme.evaluate(MapperS.of(fpmlSentBy).<String>map("getValue", messageAddress -> messageAddress.getValue()).get(), MapperS.of(fpmlSentBy).<String>map("getMessageAddressScheme", messageAddress -> messageAddress.getMessageAddressScheme()).get()))
				.setSentTo(MapperC.<MessageAddress>of(fpmlSendToList)
					.mapItem(item -> MapperS.of(mapStringWithScheme.evaluate(item.<String>map("getValue", messageAddress -> messageAddress.getValue()).get(), item.<String>map("getMessageAddressScheme", messageAddress -> messageAddress.getMessageAddressScheme()).get()))).getMulti())
				.build());
			
			return Optional.ofNullable(messageInfo)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
