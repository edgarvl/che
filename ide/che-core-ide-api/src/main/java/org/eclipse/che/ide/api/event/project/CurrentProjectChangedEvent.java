/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.api.event.project;

import com.google.gwt.event.shared.GwtEvent;

import org.eclipse.che.api.workspace.shared.dto.ProjectConfigDto;

import javax.validation.constraints.NotNull;

/**
 * This event should be fired when we select different projects.
 *
 * @author Dmitry Shnurenko
 */
public class CurrentProjectChangedEvent extends GwtEvent<CurrentProjectChangedHandler> {

    /** Type class used to register this event. */
    public static Type<CurrentProjectChangedHandler> TYPE = new Type<>();

    private final ProjectConfigDto configDto;

    /**
     * Creates an event to initiate changing of current project.
     *
     * @param configDto
     *         selected project
     */
    public CurrentProjectChangedEvent(@NotNull ProjectConfigDto configDto) {
        this.configDto = configDto;
    }

    @Override
    public Type<CurrentProjectChangedHandler> getAssociatedType() {
        return TYPE;
    }

    /** Returns descriptor of the project. */
    @NotNull
    public ProjectConfigDto getProjectConfig() {
        return configDto;
    }

    @Override
    protected void dispatch(CurrentProjectChangedHandler handler) {
        handler.onCurrentProjectChanged(this);
    }
}
